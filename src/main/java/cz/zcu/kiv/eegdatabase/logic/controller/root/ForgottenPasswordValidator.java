package cz.zcu.kiv.eegdatabase.logic.controller.root;

import cz.zcu.kiv.eegdatabase.data.dao.PersonDao;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

/**
 * @author JiPER
 */
public class ForgottenPasswordValidator implements Validator {

    private Log log = LogFactory.getLog(getClass());
    private PersonDao personDao;

    public boolean supports(Class clazz) {
        return clazz.equals(ForgottenPasswordCommand.class);
    }

    public void validate(Object command, Errors errors) {
        ForgottenPasswordCommand fpc = (ForgottenPasswordCommand) command;

        if (!personDao.usernameExists(fpc.getUsername())) {
            errors.rejectValue("username", "invalid.username");
        }
    }

    public PersonDao getPersonDao() {
        return personDao;
    }

    public void setPersonDao(PersonDao personDao) {
        this.personDao = personDao;
    }
}
