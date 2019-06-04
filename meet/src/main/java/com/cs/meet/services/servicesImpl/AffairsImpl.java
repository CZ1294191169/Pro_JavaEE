package com.cs.meet.services.servicesImpl;

import com.cs.meet.repository.affairstablerepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AffairsImpl {

    @Autowired
    com.cs.meet.repository.affairstablerepository affairstablerepository;


}
