package lesson7.generics.containers.service;

import lesson7.generics.containers.service.annotations.InitService;
import lesson7.generics.containers.service.annotations.Service;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;

/**
 * Created by prulov on 26.06.2016.
 */
public class ApplicationManager<T> {

    private boolean checkServ;

    public void startClassMarkedByAnno(Class<T> sCl){

        if(sCl.isAnnotationPresent(Service.class)){

            checkServ = true;
            System.out.println("Class Launched");
        }else{
            System.out.println("That class is not marked with annotations @Service");
        }
    }

    public void haveAnnotation(Class<T> sCl) {

        Method[] method = sCl.getMethods();
        for(Method mtd: method) {
            if(mtd.isAnnotationPresent(InitService.class)) {
                System.out.println("method has annotation");
            }
        }
    }

    public T getService(Class<T> clazz) throws Exception{

        for (Annotation ann : clazz.getAnnotations()) {
            if (ann instanceof Service) {
                for (Method method : clazz.getClass().getMethods()) {
                    for (Annotation methodAnn : method.getAnnotations()) {
                        if (methodAnn.annotationType().getSimpleName().equals(InitService.class.getSimpleName())) {
                            T service = clazz.newInstance();
                            method.invoke(service);
                            return service;
                        }
                    }
                }
            }
        }
        return null;
    }


}
