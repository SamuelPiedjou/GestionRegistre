package com.gestionregistre.controller;

import com.gestionregistre.domain.ApiResponseDTO;
import com.gestionregistre.entity.CheckList;
import com.gestionregistre.service.CheckListService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/checklist")
public class CheckListController {

    private final CheckListService service ;

    public CheckListController(CheckListService service){
        this.service = service;
    }

    @PostMapping("/add")
    public ApiResponseDTO<CheckList> add(@RequestBody CheckList checkList){
        return service.addCheckList(checkList);
    }

    @PutMapping("/update/{idCheckList}")
    public ApiResponseDTO<CheckList> updateCheckList(@PathVariable Long idCheckList,@RequestBody CheckList checkList) throws Exception {
        return service.upDateCheckList(idCheckList,checkList);
    }
    @GetMapping("/getbyid/{idCheckList}")
    public ApiResponseDTO<CheckList> getCheckList(@PathVariable Long idCheckList){
        return service.getCheckListId(idCheckList);
    }
    @GetMapping("/getall")
    public ResponseEntity<List<CheckList>> getChecklistAll(){
        return new ResponseEntity<>(service.getALlCheckList(),null, HttpStatus.OK);
    }
    @DeleteMapping("/delete/{idCheckList}")
    public ApiResponseDTO<CheckList> deleteChecklist(@PathVariable Long idCheckList){
        return service.deleteCheckList(idCheckList);
    }
}
