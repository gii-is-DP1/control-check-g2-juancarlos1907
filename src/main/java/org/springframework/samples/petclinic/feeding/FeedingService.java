package org.springframework.samples.petclinic.feeding;
import org.springframework.samples.petclinic.pet.Pet;
import org.springframework.samples.petclinic.pet.PetType;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;

public class FeedingService {

    private FeedingRepository feedingRepository;

    public List<Feeding> getAll(){
        return null;
    }

    public List<FeedingType> getAllFeedingTypes(){
        return feedingRepository.findAllFeedingTypes();
    }

    public FeedingType getFeedingType(String typeName) {
        return null;
    }

    @Transactional(rollbackFor = UnfeasibleFeedingException.class)
    public Feeding save(Feeding p) throws UnfeasibleFeedingException {
        FeedingType f = p.getFeedingType();
        PetType a = p.getPet().getType();
        if(f.getPetType()!=a){
           throw new UnfeasibleFeedingException();
        }else{
            return feedingRepository.save(p);
        }
    }

    
}
