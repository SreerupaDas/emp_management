package com.admin.employment.service;

import com.admin.employment.dto.LoginDTO;
import com.admin.employment.entity.CredentialEntity;
import com.admin.employment.repository.CredentialRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpSession;
import java.util.Objects;

@Service
public class LoginService {

    @Autowired
    private CredentialRepository credentialRepository;

    public boolean login(LoginDTO loginDTO) {
        CredentialEntity credential = credentialRepository.findByUsernameAndPassword(
                loginDTO.getUserName(), loginDTO.getPassword());
        if(Objects.nonNull(credential)) {
            ServletRequestAttributes requestAttributes = (ServletRequestAttributes) RequestContextHolder
                    .currentRequestAttributes();
            HttpSession session = requestAttributes.getRequest().getSession(true);
            session.setAttribute("loggedIn", true);
            return true;
        }
        return false;
    }

    public boolean isUserLoggedIn() {
        ServletRequestAttributes requestAttributes = (ServletRequestAttributes) RequestContextHolder
                .currentRequestAttributes();
        HttpSession session = requestAttributes.getRequest().getSession();
        return Objects.nonNull(session) && Objects.nonNull(session.getAttribute("loggedIn")) ?
                (boolean)session.getAttribute("loggedIn") : false;
    }
}
