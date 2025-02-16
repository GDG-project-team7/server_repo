package com.example.hipple.service;
import com.example.hipple.domain.Login;
import com.example.hipple.dto.request.SignInRequestDTO;
import com.example.hipple.dto.response.SignInResponseDTO;
import com.example.hipple.repository.LoginRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class LoginService {
    private final LoginRepository loginRepository;

    public SignInResponseDTO signIn(SignInRequestDTO req){
        Login login = loginRepository.findByLoginId(req.getLoginId())
                .orElseThrow(() -> new RuntimeException("존재하지 않는 아이디입니다."));

        if(!login.getPassword().equals(req.getPassword())){
            throw new IllegalStateException("비밀번호가 잘못되었습니다.");
        }

        return SignInResponseDTO.builder()
                .id(login.getId())
                .name(login.getName())
                .age(login.getAge())
                .portfolio(login.getPortfolio())
                .role(login.getRole())
                .build();
    }
}