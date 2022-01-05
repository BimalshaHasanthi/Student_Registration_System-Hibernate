package bo.custom.impl;

import bo.custom.ProgramBO;
import dao.DAOFactory;
import dao.custom.impl.ProgramDAOImpl;
import dto.ProgramDTO;
import entity.Program;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ProgramBOImpl implements ProgramBO {

    private final ProgramDAOImpl programDAO = DAOFactory.getInstance().getDAO(DAOFactory.DAOType.PROGRAM);

    @Override
    public boolean add(ProgramDTO programDTO) throws Exception {
        return programDAO.add(new Program(
                programDTO.getId(),
                programDTO.getName(),
                programDTO.getDuration(),
                programDTO.getFee()
        ));
    }

    @Override
    public boolean delete(String id) throws Exception {
        return programDAO.delete(id);
    }

    @Override
    public boolean update(ProgramDTO programDTO) throws Exception {
        return programDAO.update(new Program(
                programDTO.getId(),
                programDTO.getName(),
                programDTO.getDuration(),
                programDTO.getFee()
        ));
    }

    @Override
    public List<ProgramDTO> searchAll() throws Exception {
        List<Program> all = programDAO.searchAll();
        ArrayList<ProgramDTO> programDTOS = new ArrayList<>();

        for (Program program : all) {
            programDTOS.add(new ProgramDTO(
                    program.getId(),
                    program.getName(),
                    program.getDuration(),
                    program.getFee()
            ));
        }
        return programDTOS;
    }

    @Override
    public ProgramDTO search(String id) {
        try {
            Program item=programDAO.search(id);
            return new ProgramDTO(item.getId(),item.getName(),item.getDuration(),item.getFee());
        } catch (Exception throwables) {
            throwables.printStackTrace();
        }
        return null;
    }
}
