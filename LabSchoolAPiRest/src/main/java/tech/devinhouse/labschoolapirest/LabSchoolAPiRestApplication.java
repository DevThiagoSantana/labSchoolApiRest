package tech.devinhouse.labschoolapirest;

import org.modelmapper.ModelMapper;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;
import org.springframework.validation.beanvalidation.LocalValidatorFactoryBean;
import tech.devinhouse.labschoolapirest.model.Aluno;
import tech.devinhouse.labschoolapirest.model.Pedagogo;
import tech.devinhouse.labschoolapirest.model.Professor;
import tech.devinhouse.labschoolapirest.service.AlunoService;
import tech.devinhouse.labschoolapirest.service.PedagogoService;
import tech.devinhouse.labschoolapirest.service.ProfessorService;

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
            List<Pedagogo> listaPedagogo =pedagogoService.consultar();
            List<Professor>listaProfessor = professorService.consultar();

            if (listaAluno.isEmpty()) {
                alunoService.salvar(new Aluno(null,"Bart Simpson","11-11111-1212",2014/10/29,11839750073L, "IRREGULAR",3.5f);
                alunoService.salvar(new Aluno(null,"Lisa Simpson","11-22222-2222",2012/10/29,17158947076L,"ATIVO",10f);
                alunoService.salvar(new Aluno(null,"Merge Simpson","12-20002-2200",2019-10-29,63701210020L,"ATIVO",9f);
                alunoService.salvar(new Aluno(null,"Milhouse Van Houten","11-33333-2222",2014-10-29,30119137062L,"ATIVO",8f);
                alunoService.salvar(new Aluno(null,"Nelson Muntz","11-44333-4444",2007-10-29,95704094015L,"INATIVO",2f);
            }
            if (listaProfessor.isEmpty()){
                professorService.salvar(new Professor(null,"Walter White","14-22998-1882",1982-10-30,40539019011L, "ATIVO","FULL_STACK","MESTRADO");
                professorService.salvar(new Professor(null,"Jesse Pinkman","44-11111-1992",1997-10-30,96107295097L,"ATIVO","BACK_END","GRADUACAO_INCOMPLETA");
                professorService.salvar(new Professor(null,"Hank Schrader","44-11111-1002",1984-10-30,70685977005L,"ATIVO","FULL_STACK","MESTRADO");
                professorService.salvar(new Professor(null,"Gustavo Fring","44-11001-1002",1977-10-30,57408927085L,"INATIVO","FRONT_END","GRADUACAO_COMPLETA");
                professorService.salvar(new Professor(null,"Saul Goodman","44-11998-1882",1980-10-30,86940162062L,"ATIVO","FULL_STACK","MESTRADO");

            }

            if (listaPedagogo.isEmpty()){
                pedagogoService.salvar(new Pedagogo(null,"John Snow","11-67333-4454",2000-10-30,62316840086L);
                pedagogoService.salvar(new Pedagogo(null,"Sansa Stark","22-22333-4454",2004-10-30 ,49850253053L);
                pedagogoService.salvar(new Pedagogo(null,"Tyrion Lannister","33-77333-4454",1990-10-30,39125106015L);
                pedagogoService.salvar(new Pedagogo(null,"Sandor Clegane","11-33333-2222",1995-10-30,89089606009L);


            }

        };
    }



}
