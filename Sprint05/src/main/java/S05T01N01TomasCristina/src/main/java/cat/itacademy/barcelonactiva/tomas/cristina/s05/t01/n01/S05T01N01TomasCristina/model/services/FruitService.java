package cat.itacademy.barcelonactiva.tomas.cristina.s05.t01.n01.S05T01N01TomasCristina.model.services;
import cat.itacademy.barcelonactiva.tomas.cristina.s05.t01.n01.S05T01N01TomasCristina.model.dto.BranchDTO;

import java.util.List;

public interface FruitService {
    BranchDTO addBranch(BranchDTO branchDTO);
    BranchDTO updateBranch(Integer id, BranchDTO branchDTO);
    void deleteBranch(Integer id);
    BranchDTO getOneBranch(Integer id);
    List<BranchDTO> getAllBranches();
}
