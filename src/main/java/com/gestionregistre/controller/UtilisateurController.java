package com.gestionregistre.controller;

import com.gestionregistre.domain.ApiResponseDTO;
import com.gestionregistre.domain.UtilisateurDto;
import com.gestionregistre.entity.Profile;
import com.gestionregistre.entity.Utilisateur;
import com.gestionregistre.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/utilisateur")
public class UtilisateurController {


    private final UserService service;

    public UtilisateurController(UserService service){
        this.service=service;
    }

    @PostMapping("/addUser")
    public @ResponseBody ApiResponseDTO<UtilisateurDto> newUser(@RequestBody UtilisateurDto utilisateurDto){
        return service.saveUser(utilisateurDto);
    }

    @GetMapping("/finduserbyid/{idUser}")
    public @ResponseBody ApiResponseDTO<UtilisateurDto> getUserById(@PathVariable Long idUser) throws Exception {
        return service.getUserById(idUser);
    }

    @GetMapping("/finduserbyid/{email}")
    public @ResponseBody ApiResponseDTO<UtilisateurDto> getUserByEmail(@PathVariable String email){
        return service.getUserByEmail(email);
    }

    @GetMapping("/finduserbyid/{phone}")
    public @ResponseBody ApiResponseDTO<UtilisateurDto> getUserByPhoen(@PathVariable String phone){
        return service.getUserByPhone(phone);
    }

    @PutMapping("/updateuser/{phone}")
    public @ResponseBody ApiResponseDTO<UtilisateurDto> updateUser(@PathVariable String phone,@RequestBody UtilisateurDto userDTO){
        return service.updateInfoUser(phone,userDTO);
    }

    @PutMapping("/updateprofile/{phone}")
    public @ResponseBody ApiResponseDTO<UtilisateurDto> updateProfile(@PathVariable String phone ,@RequestBody Profile profile){
        return service.updateProfile(phone,profile);
    }

    @GetMapping("/getalluser")
    public ResponseEntity<List<UtilisateurDto>> listUser(){
        return new ResponseEntity<>(service.listUser(), null, HttpStatus.OK);
    }

}
