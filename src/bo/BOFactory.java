package bo;

import bo.custom.impl.DetailBOImpl;
import bo.custom.impl.ProgramBOImpl;
import bo.custom.impl.StudentBOImpl;

public class BOFactory {
    private static BOFactory boFactory;

    private BOFactory(){}

    public static BOFactory getInstance(){
        return (null == boFactory) ? boFactory = new BOFactory() : boFactory;
    }

    public enum BOType{
        STUDENT,PROGRAM,DETAIL
    }

    public <T extends SuperBO> T getBO(BOType boType){
        switch (boType){
            case STUDENT:
                return (T) new StudentBOImpl();
            case PROGRAM:
                return (T) new ProgramBOImpl();
            case DETAIL:
                return (T) new DetailBOImpl();
            default:
                return null;
        }
    }
}
