package org.itstep.msk.app.controller;

import org.itstep.msk.app.entity.Account;
import org.itstep.msk.app.entity.Operation;
import org.itstep.msk.app.entity.User;
import org.itstep.msk.app.enums.OperationType;
import org.itstep.msk.app.repository.AccountRepository;
import org.itstep.msk.app.repository.OperationRepository;
import org.itstep.msk.app.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.security.Principal;
import java.util.List;
import java.util.Optional;


/**
 * Created by User on 22.11.2019.
 */
@Controller
@CrossOrigin(origins = "*")
public class DashboardController {
    @Autowired
    UserRepository userRepository;
    @Autowired
    AccountRepository accountRepository;
    @Autowired
    OperationRepository operationRepository;

    @GetMapping("/dashboard")
    public String username(){
        return "dashboard";
    }

    @PostMapping("/dashboard")
    @ResponseBody
    public List<Account> list(Principal principal) {
        User user = userRepository.findByUsername(principal.getName()).orElse(null);
        return accountRepository.findByUser(user);
    }

    @DeleteMapping("/dashboard/{accountId}")
    public String delete(
            @PathVariable Integer accountId,
            HttpServletResponse response
    ) {

        Optional<Account> account = accountRepository.findById(accountId);
        if (account.isPresent()) {
            accountRepository.delete(account.get());
        } else {
            response.setStatus(HttpServletResponse.SC_NOT_FOUND);
        }
        return "OK";
    }

    @GetMapping("/accountform")
    public String getForm(Model model) {
        model.addAttribute("account", new Account());
        return "accountform";
    }

    @PostMapping("/accountform")
    public String add(@ModelAttribute Account account, Principal principal) {
        User user = userRepository.findByUsername(principal.getName()).orElse(null);
        account.setUser(user);
        accountRepository.save(account);
        accountRepository.flush();
        return "redirect:/dashboard";
    }

    @GetMapping("/transactionform")
    public String getTransactionForm(Model model) {
        model.addAttribute("operation", new Operation());
        return "transactionform";
    }

    @PostMapping("/transactionform")
    public String transaction(@ModelAttribute Operation operation) {
        operation.setOperationType(OperationType.TRANSFER);
        operationRepository.save(operation);
        Integer operationAmmount = operation.getOperationAmmount();
        Account account = accountRepository.getOne(operation.getAccount().getId());
        account.setAmmount(account.getAmmount() - operationAmmount);
        accountRepository.save(account);
        Account targetAccount = accountRepository.getOne(operation.getTargetAccount().getId());
        targetAccount.setAmmount(targetAccount.getAmmount() + operationAmmount);
        accountRepository.save(targetAccount);
        return "redirect:/dashboard";
    }
}
