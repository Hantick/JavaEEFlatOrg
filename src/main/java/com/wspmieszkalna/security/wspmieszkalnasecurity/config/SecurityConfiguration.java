package com.wspmieszkalna.security.wspmieszkalnasecurity.config;


import com.wspmieszkalna.security.wspmieszkalnasecurity.dbModels.repositories.ResidentsRepository;
import com.wspmieszkalna.security.wspmieszkalnasecurity.service.CustomResidentsDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@EnableGlobalMethodSecurity(prePostEnabled = true)
@EnableWebSecurity
@EnableJpaRepositories(basePackageClasses = ResidentsRepository.class)
@Configuration

public class SecurityConfiguration extends WebSecurityConfigurerAdapter {

    @Autowired
    private CustomResidentsDetailsService residentsDetailsService;

    @Bean
    public BCryptPasswordEncoder bCryptPasswordEncoder() {
        return new BCryptPasswordEncoder();
    }
    @Bean
    public AuthenticationManager customAuthenticationManager() throws Exception {
        return authenticationManager();
    }
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception{
        auth.userDetailsService(residentsDetailsService)
                .passwordEncoder(getPasswordEncoder());
    }
    //trzeba bedzie zrobic lepszy/zaimplementowac
    private PasswordEncoder getPasswordEncoder() {
        return new PasswordEncoder() {
            @Override
            public String encode(CharSequence charSequence) {
                return charSequence.toString();
            }

            @Override
            public boolean matches(CharSequence charSequence, String s) {
                return (encode(charSequence)).equals(s);
            }
        };
    }

    @Override
    protected void configure(HttpSecurity httpSecurity) throws Exception
    {
        httpSecurity.csrf().disable();
        httpSecurity.authorizeRequests()
                    //.anyRequest()
                    .antMatchers("**/secured/**").authenticated()   //wszystko z zapiskiem secured bedzie wymagac logowania
                    .anyRequest().permitAll()// pozwol wszystkim
                    //.fullyAuthenticated() // kazdy requst bedzie authowany
                    .and().formLogin().loginPage("/login").permitAll();


    }
    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(residentsDetailsService).passwordEncoder(bCryptPasswordEncoder());
    }

}
