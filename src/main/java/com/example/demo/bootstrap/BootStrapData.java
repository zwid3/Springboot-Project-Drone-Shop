package com.example.demo.bootstrap;

import com.example.demo.domain.OutsourcedPart;
import com.example.demo.domain.Part;
import com.example.demo.domain.Product;
import com.example.demo.repositories.OutsourcedPartRepository;
import com.example.demo.repositories.PartRepository;
import com.example.demo.repositories.ProductRepository;
import com.example.demo.service.OutsourcedPartService;
import com.example.demo.service.OutsourcedPartServiceImpl;
import com.example.demo.service.ProductService;
import com.example.demo.service.ProductServiceImpl;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

/**
 *
 *
 *
 *
 */
@Component
public class BootStrapData implements CommandLineRunner {

    private final PartRepository partRepository;
    private final ProductRepository productRepository;

    private final OutsourcedPartRepository outsourcedPartRepository;

    public BootStrapData(PartRepository partRepository, ProductRepository productRepository, OutsourcedPartRepository outsourcedPartRepository) {
        this.partRepository = partRepository;
        this.productRepository = productRepository;
        this.outsourcedPartRepository = outsourcedPartRepository;
    }

    /*Created an if statement to check if there was 0 in each repository*/
    /*Added sample inventory and saved it to the repository*/
    @Override
    public void run(String... args) throws Exception {


        List<OutsourcedPart> outsourcedParts = (List<OutsourcedPart>) outsourcedPartRepository.findAll();
        Set<String> existingParts = new HashSet<>();

        for (OutsourcedPart part : outsourcedParts) {
            existingParts.add(part.getName());

        }
        if (outsourcedPartRepository.count() == 0 && productRepository.count() == 0) {
            OutsourcedPart c = new OutsourcedPart();
            c.setCompanyName("Mpanedziba Suppliers");
            c.setName("DJI Sling Bag");
            c.setInv(100);
            c.setPrice(89.99);
            c.setId(10L);
            c.setMinInv(1);
            c.setMaxInv(100);


            OutsourcedPart s = new OutsourcedPart();
            s.setCompanyName("Malapala Suppliers");
            s.setName("DJI Power 1000");
            s.setInv(100);
            s.setPrice(799.99);
            s.setId(11L);
            c.setMinInv(1);
            c.setMaxInv(100);


            OutsourcedPart ca = new OutsourcedPart();
            ca.setCompanyName("Tshiyakwakhiwe Suppliers");
            ca.setName("DJI Air 3 Battery Charging Hub");
            ca.setInv(100);
            ca.setPrice(79.99);
            ca.setId(12L);
            c.setMinInv(1);
            c.setMaxInv(100);


            OutsourcedPart o = new OutsourcedPart();
            o.setCompanyName("Wankie Suppliers");
            o.setName("DJI Googles 3");
            o.setInv(100);
            o.setPrice(499.99);
            o.setId(13L);
            c.setMinInv(1);
            c.setMaxInv(100);


            OutsourcedPart f = new OutsourcedPart();
            f.setCompanyName("Melisizwe Suppliers");
            f.setName("DJI RC Motion 3");
            f.setInv(100);
            f.setPrice(199.99);
            f.setId(10L);
            c.setMinInv(1);
            c.setMaxInv(100);


            /*Commented out the code here*/

        /*OutsourcedPart thePart=null;
        List<OutsourcedPart> outsourcedParts=(List<OutsourcedPart>) outsourcedPartRepository.findAll();
        for(OutsourcedPart part:outsourcedParts){
            if(part.getName().equals("Coils"))thePart=part;
        }

        System.out.println(thePart.getCompanyName());*/

            List<OutsourcedPart> outsourcedPartsToAdd = List.of(c, s, ca, o, f);

            for (OutsourcedPart part : outsourcedPartsToAdd) {
                if (existingParts.contains(part.getName())) {
                    OutsourcedPart multipack = new OutsourcedPart();
                    multipack.setCompanyName(part.getCompanyName());
                    multipack.setName(part.getName() + " Multi-pack");
                    multipack.setInv(part.getInv());
                    multipack.setPrice(part.getPrice());
                    multipack.setId(part.getId());

                    outsourcedPartRepository.save(multipack);
                    System.out.println(part.getName() + " " + part.getCompanyName());
                } else {
                    outsourcedPartRepository.save(part);
                    System.out.println(part.getName() + " " + part.getCompanyName());
                }
            }


            /*Created new sample inventory for the products*/
            Product djimavic = new Product("DJI Mavic 3 Pro", 2199.99, 10);
            Product djiair3 =  new Product("DJI Air 3", 1099.99, 10);
            Product djimini =  new Product("DJI Mini 4 Pro", 789.99, 10);
            Product djimini3 = new Product("DJI Mini 3 Pro", 419.99, 10);
            Product djimini2 = new Product("DJI Mini 2 SE", 529.99, 10);

            productRepository.save(djimavic);
            productRepository.save(djiair3);
            productRepository.save(djimini);
            productRepository.save(djimini3);
            productRepository.save(djimini2);


            System.out.println("Started in Bootstrap");
            System.out.println("Number of Products" + productRepository.count());
            System.out.println(productRepository.findAll());
            System.out.println("Number of Parts" + partRepository.count());
            System.out.println(partRepository.findAll());

        }
    }
}
