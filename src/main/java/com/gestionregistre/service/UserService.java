package com.gestionregistre.service;

import com.gestionregistre.domain.ApiResponseDTO;
import com.gestionregistre.domain.UtilisateurDto;
import com.gestionregistre.entity.Profile;
import com.gestionregistre.entity.Utilisateur;
import com.gestionregistre.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserService {

    private UserRepository userRepo;

    public UserService(UserRepository userRepo){
        this.userRepo = userRepo;
    }
    public ApiResponseDTO<UtilisateurDto> saveUser(UtilisateurDto userDTO){
        userDTO.setDateCreation(new Date());
        Utilisateur utilisateur = new Utilisateur(userDTO);
        return new ApiResponseDTO<UtilisateurDto>(userDTO.getPhoneNumber(), "success", new UtilisateurDto(userRepo.save(utilisateur)), true, false);

    }
    public List<UtilisateurDto> listUser(){
        return userRepo.findAll().stream().map(UtilisateurDto::new).collect(Collectors.toList());
    }

    public ApiResponseDTO<UtilisateurDto> getUserById(Long id) throws Exception {
        Utilisateur user = userRepo.findById(id).orElseThrow(() -> new Exception("user not found with"));
        return  new ApiResponseDTO<UtilisateurDto>(user.getIdUser().toString(),"success",new UtilisateurDto(user),true,false);
    }

    public ApiResponseDTO<UtilisateurDto> getUserByEmail(String email){
        Utilisateur user = userRepo.findUtilisateurByEmail(email);
        if(user == null) new Exception("user not found with given email");
        return new ApiResponseDTO<UtilisateurDto>(user.getIdUser().toString(),"success",new UtilisateurDto(user),true, false);
    }
    public ApiResponseDTO<UtilisateurDto> getUserByPhone(String tel){
        Utilisateur user = userRepo.findUtilisateurByPhoneNumber(tel);
        if(user == null) new Exception("user not found with given phone number");
        return new ApiResponseDTO<UtilisateurDto>(user.getIdUser().toString(),"success",new UtilisateurDto(user),true, false);

    }
    public UtilisateurDto findByPhone(String tel){
        Utilisateur user = userRepo.findUtilisateurByPhoneNumber(tel);
        if(user == null) new Exception("user not found with given phone number");
        return new UtilisateurDto(user);
    }

    public ApiResponseDTO<UtilisateurDto> updateInfoUser(String phone, UtilisateurDto userDTO){
        UtilisateurDto existingUserDTO = new UtilisateurDto();
        Utilisateur user;
        if (phone != userDTO.getPhoneNumber()){
            existingUserDTO= findByPhone(userDTO.getPhoneNumber());
        }
        existingUserDTO.setNomUser(userDTO.getNomUser());
        existingUserDTO.setPrenomUser(userDTO.getPrenomUser());
        existingUserDTO.setAdresse(userDTO.getAdresse());
        existingUserDTO.setPhoneNumber(userDTO.getPhoneNumber());
        existingUserDTO.setEmail(userDTO.getEmail());
        user = new Utilisateur(existingUserDTO);

        return new ApiResponseDTO<UtilisateurDto>(user.getIdUser().toString(),"success",new UtilisateurDto(userRepo.save(user)),true, false);
    }

    public ApiResponseDTO<UtilisateurDto> updateProfile(String phone,Profile profile){
        UtilisateurDto userDTO = findByPhone(phone);
        userDTO.setProfile(profile);
        Utilisateur user = new Utilisateur(userDTO);
        return new ApiResponseDTO<UtilisateurDto>(user.getIdUser().toString(),"success",new UtilisateurDto(userRepo.save(user)),true, false);

    }


}
