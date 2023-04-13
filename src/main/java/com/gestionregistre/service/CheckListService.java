package com.gestionregistre.service;

import com.gestionregistre.domain.ApiResponseDTO;
import com.gestionregistre.entity.CheckList;
import com.gestionregistre.repository.CheckListRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CheckListService {

    private final CheckListRepository repo;
    public CheckListService(CheckListRepository repo){
        this.repo=repo;
    }

    public CheckList findCheckListByid(Long id){
        return repo.findById(id).orElseThrow(()->new RuntimeException("NOt FOUND"));
    }
    public ApiResponseDTO<CheckList> addCheckList(CheckList checkList){
        return new ApiResponseDTO<CheckList>(checkList.getIdCheckList().toString(),"success",repo.save(checkList),true,false);
    } 
    
    public ApiResponseDTO<CheckList> getCheckListId(Long id){
        return new ApiResponseDTO<CheckList>(id.toString(),"success",findCheckListByid(id),true,false);
    }

    public ApiResponseDTO<CheckList> upDateCheckList(Long id, CheckList checkList) throws Exception{
        CheckList existCheckList = findCheckListByid(id);
        if (id ==null && checkList == null)return null;
        existCheckList.setLisibleEtiquette(checkList.getLisibleEtiquette());
        existCheckList.setValidEmplacement(checkList.getValidEmplacement());
        existCheckList.setValidEtiqEntretien(checkList.getValidEtiqEntretien());
        existCheckList.setValidEtiquette(checkList.getValidEtiquette());
        existCheckList.setValidGoupille(checkList.getValidGoupille());
        existCheckList.setValidTuyau(checkList.getValidTuyau());
        return new ApiResponseDTO<CheckList>(id.toString(),"success",repo.save(checkList),true,false);
    }

    public ApiResponseDTO<CheckList> deleteCheckList(Long id){
        CheckList checkList = findCheckListByid(id);
        repo.delete(checkList);
        return new ApiResponseDTO<CheckList>(id.toString(),"success",checkList,true,false);
    }

    public List<CheckList> getALlCheckList(){return repo.findAll();}
}
