package tech.devinhouse.labschoolapirest;

import org.modelmapper.ModelMapper;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;
import org.springframework.validation.beanvalidation.LocalValidatorFactoryBean;
import tech.devinhouse.labschoolapirest.model.*;
import tech.devinhouse.labschoolapirest.service.AlunoService;
import tech.devinhouse.labschoolapirest.service.PedagogoService;
import tech.devinhouse.labschoolapirest.service.ProfessorService;

import java.time.LocalDate;
import java.util.List;

@SpringBootApplication
public class LabSchoolAPiRestApplication {

    public static void main(String[] args) {
        SpringApplication.run(LabSchoolAPiRestApplication.class, args);
    }


    @Bean
    public MessageSource messageSource() {
        ReloadableResourceBundleMessageSource messageSource = new ReloadableResourceBundleMessageSource();
        messageSource.setBasename("classpath:messages");
        messageSource.setDefaultEncoding("UTF-8");
        return messageSource;
    }

    @Bean
    public LocalValidatorFactoryBean validator() {
        LocalValidatorFactoryBean bean = new LocalValidatorFactoryBean();
        bean.setValidationMessageSource(messageSource());
        return bean;
    }

    @Bean
    public ModelMapper modelMapper() {
        ModelMapper modelMapper = new ModelMapper();
        return modelMapper;
    }

    @Bean
    CommandLineRunner run(AlunoService alunoService, PedagogoService pedagogoService, ProfessorService professorService) {
        return args -> {
            List<Aluno> listaAluno = alunoService.consultar();
            List<Professor>listaProfessor = professorService.consultar();
            List<Pedagogo> listaPedagogo =pedagogoService.consultar();


            if (listaAluno.isEmpty()) {
                alunoService.salvar(new Aluno(null,"Bart Simpson","11-11111-1212", LocalDate.of(2014,10,29),11839750073L, SituacaoDaMatricula.IRREGULAR,3.5f));
                alunoService.salvar(new Aluno(null,"Lisa Simpson","11-22222-2222",LocalDate.of(2012,10,29),17158947076L,SituacaoDaMatricula.ATIVO,10f));
                alunoService.salvar(new Aluno(null,"Merge Simpson","12-20002-2200",LocalDate.of(2019,10,29),63701210020L,SituacaoDaMatricula.ATIVO,9f));
                alunoService.salvar(new Aluno(null,"Milhouse Van Houten","11-33333-2222",LocalDate.of(2014,10,29),30119137062L,SituacaoDaMatricula.ATIVO,8f));
                alunoService.salvar(new Aluno(null,"Nelson Muntz","11-44333-4444",LocalDate.of(2007,10,29),95704094015L,SituacaoDaMatricula.INATIVO,2f));
            }
            if (listaProfessor.isEmpty()){
                professorService.salvar(new Professor(null,"Walter White","14-22998-1882",LocalDate.of(1982,10,30),40539019011L, EstadoProfessor.ATIVO,ExperienciaProfessor.FULL_STACK,FormacaoProfessor.MESTRADO));
                professorService.salvar(new Professor(null,"Jesse Pinkman","44-11111-1992",LocalDate.of(1997,10,30),96107295097L,EstadoProfessor.ATIVO,ExperienciaProfessor.BACK_END,FormacaoProfessor.GRADUACAO_INCOMPLETA));
                professorService.salvar(new Professor(null,"Hank Schrader","44-11111-1002",LocalDate.of(1984,10,30),70685977005L,EstadoProfessor.ATIVO,ExperienciaProfessor.FULL_STACK,FormacaoProfessor.MESTRADO));
                professorService.salvar(new Professor(null,"Gustavo Fring","44-11001-1002",LocalDate.of(1977,10,30),57408927085L,EstadoProfessor.ATIVO,ExperienciaProfessor.FRONT_END,FormacaoProfessor.GRADUCAO_COMPLETA));
                professorService.salvar(new Professor(null,"Saul Goodman","44-11998-1882",LocalDate.of(1980,10,30),86940162062L,EstadoProfessor.ATIVO,ExperienciaProfessor.FULL_STACK,FormacaoProfessor.MESTRADO));

            }

            if (listaPedagogo.isEmpty()){
                pedagogoService.salvar(new Pedagogo(null,"John Snow","11-67333-4454",LocalDate.of(2000,10,30),62316840086L));
                pedagogoService.salvar(new Pedagogo(null,"Sansa Stark","22-22333-4454",LocalDate.of(2004,10,30) ,49850253053L));
                pedagogoService.salvar(new Pedagogo(null,"Tyrion Lannister","33-77333-4454",LocalDate.of(1990,10,30),39125106015L));
                pedagogoService.salvar(new Pedagogo(null,"Sandor Clegane","11-33333-2222",LocalDate.of(1995,10,30),89089606009L));


            }

        };
    }



}
