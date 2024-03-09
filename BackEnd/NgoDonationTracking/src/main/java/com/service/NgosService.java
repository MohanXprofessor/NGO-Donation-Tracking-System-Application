package com.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.dao.NgosRepository;
import com.model.Ngos;
import java.util.List;

@Service

public class NgosService {
    @Autowired
    private NgosRepository ngoRepository;
    
  
    public Ngos saveNgo(Ngos ngo) {
        return ngoRepository.save(ngo);
    }

    public Ngos getNgoById(int id) {
        return ngoRepository.findById(id).orElse(null);
    }

    public Ngos getNgoByName(String name) {
    	return ngoRepository.getNgoByName(name);    
    	}

    public List<Ngos> getAllNgos() {
        return ngoRepository.findAll();
    }
   
    public Ngos updateNgo(int id, Ngos updatedNgo) {
    	Ngos existingNgo = ngoRepository.findById(id).orElse(null);

        if (existingNgo != null) {
        	if(updatedNgo.getName()!=null) {
        	existingNgo.setName(updatedNgo.getName());
        	}
        	if(updatedNgo.getDescription()!=null) {
        	existingNgo.setDescription(updatedNgo.getDescription());
        	}

            return ngoRepository.save(existingNgo);
        }

        return null;
    }

    public void deleteNgo(int id) {
    	Ngos existingNgo = ngoRepository.findById(id).orElse(null);
    	ngoRepository.delete(existingNgo);
    }
    
    
    
    
    
//    
////    public void GetByImage(int id) {
////		Ngos ngo = ngoRepository.findById(id).orElse(null);
////		byte b[] = ngo.getImage();
////		try {
////			FileOutputStream fout =new FileOutputStream("C:\\Users\\Lenovo\\Desktop\\img\\lap.jpg");
////			fout.write(b);
////		}
////		catch(Exception e){
////			e.printStackTrace();
////		}
////		}
//    
//    
//    public void saveNgoImage(int ngoId, MultipartFile imageFile) throws Exception {
//        Ngos ngo = ngoRepository.findById(ngoId).orElseThrow(() -> new Exception("NGO not found with id: " + ngoId));
//        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
//        outputStream.write(imageFile.getBytes());
//
//        // Get the byte array from the ByteArrayOutputStream
//        byte[] imageData = outputStream.toByteArray();
//
//        // Set the image data to the NGO entity
//        ngo.setImage(imageData);
//
//        // Save the NGO entity with the image data to the database
//        ngoRepository.save(ngo);
//
//        // Close the ByteArrayOutputStream
//        outputStream.close();
//    }
}


