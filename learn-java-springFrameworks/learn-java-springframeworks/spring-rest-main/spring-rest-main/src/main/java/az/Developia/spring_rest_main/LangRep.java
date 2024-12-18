package az.Developia.spring_rest_main;

import java.util.List;

import az.Developia.spring_rest_main.Cont.TranslateRestCOnt;

public interface LangRep extends Jpa {

	List<TranslateRestCOnt> findByLanguage(String lang);

}
