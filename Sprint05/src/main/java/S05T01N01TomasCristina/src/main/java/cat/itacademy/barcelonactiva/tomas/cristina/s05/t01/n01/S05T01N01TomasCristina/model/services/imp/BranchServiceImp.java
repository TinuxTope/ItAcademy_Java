package cat.itacademy.barcelonactiva.tomas.cristina.s05.t01.n01.S05T01N01TomasCristina.model.services.imp;

import cat.itacademy.barcelonactiva.tomas.cristina.s05.t01.n01.S05T01N01TomasCristina.exceptions.BranchNotFoundException;
import cat.itacademy.barcelonactiva.tomas.cristina.s05.t01.n01.S05T01N01TomasCristina.model.domain.Branch;

import cat.itacademy.barcelonactiva.tomas.cristina.s05.t01.n01.S05T01N01TomasCristina.model.dto.BranchDTO;
import cat.itacademy.barcelonactiva.tomas.cristina.s05.t01.n01.S05T01N01TomasCristina.model.repository.BranchRepository;
import cat.itacademy.barcelonactiva.tomas.cristina.s05.t01.n01.S05T01N01TomasCristina.model.services.FruitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class BranchServiceImp implements FruitService {
    @Autowired
    private BranchRepository branchRepository;

    @Override
    public BranchDTO addBranch(BranchDTO branchDTO) {
        Branch branch = new Branch();
        branch.setBranchName(branchDTO.getBranchName());
        branch.setBranchCountry(branchDTO.getBranchCountry().toLowerCase());
        branch = branchRepository.save(branch);
        return new BranchDTO(branch.getId(), branch.getBranchName(), branch.getBranchCountry());
    }

    @Override
    public BranchDTO updateBranch(Integer id, BranchDTO branchDTO) {
        Branch branch = branchRepository.findById(id)
                .orElseThrow(() -> new BranchNotFoundException("Branch not found with id: " + id));
        branch.setBranchName(branchDTO.getBranchName());
        branch.setBranchCountry(branchDTO.getBranchCountry().toLowerCase());
        branch = branchRepository.save(branch);
        return new BranchDTO(branch.getId(), branch.getBranchName(), branch.getBranchCountry());
    }

    @Override
    public void deleteBranch(Integer id) {
        if (!branchRepository.existsById(id)) {
            throw new BranchNotFoundException("Branch not found with id: " + id);
        }
        branchRepository.deleteById(id);
    }

    @Override
    public BranchDTO getOneBranch(Integer id) {
        Branch branch = branchRepository.findById(id)
                .orElseThrow(() -> new BranchNotFoundException("Branch not found with id: " + id));
        return new BranchDTO(branch.getId(), branch.getBranchName(), branch.getBranchCountry());
    }

    @Override
    public List<BranchDTO> getAllBranches() {
        return branchRepository.findAll().stream()
                .map(branch -> new BranchDTO(branch.getId(), branch.getBranchName(), branch.getBranchCountry()))
                .collect(Collectors.toList());
    }
}
