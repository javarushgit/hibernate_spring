package org.example.aop;


import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Aspect
@Component
@Order(1)
public class FirstAspect {

    // @within - проверяет наличие у класса указанной аннотации
    @Pointcut(value = "@within(org.springframework.stereotype.Controller)")
    public void isControllerAnnotation(){
    }

    // within - проверяет наличие укзанного класса(или же паттерна) по пути и названию
    @Pointcut(value = "within(org.example.service.*Service)")
    public void isServiceLayer() {

    }

    // this - проверяет наличие класса к пренадлежности к указаному
    @Pointcut(value = "this(org.springframework.data.repository.Repository)")
    public void isRepositoryLayer() {
    }

    // combination of pointcuts
    @Pointcut("isControllerAnnotation() || @annotation(org.springframework.web.bind.annotation.PostMapping)")
    public void hasPostMapping() {
    }

    @Pointcut("args(.., java.lang.String)")
    public void isStringArgs() {

    }

    /*
        execution(modifiers-pattern? ret-type-pattern declaration-type-pattern? throws-pattern?)

        modifiers-pattern? - тип модификатора доступа(опционально)
        ret-type-pattern - тип вовзрщемого значения
        declaration-type-pattern? - класс и названием метод (опционально)
        throws-pattern? - какие ошибки выбрасывает метод(опцинально)
     */

    @Pointcut("execution(public * org.example.service.*Service.getById(*))")
    public void anyGetByIdServiceMethod() {

    }

    // this - proxy instance;
    // target - original instance
    // Advice
    @Order(1)
    @After(value = "anyGetByIdServiceMethod() && args(id) && target(service)",
            argNames = "joinPoint, id, service")
    public void loggingGetByIdMethod(JoinPoint joinPoint, Object id, Object service) {
        System.out.print("[INFO]: Get by Id method called in " + service.getClass().getSimpleName());
        System.out.println(" with id: " + id);
    }

    @Order(2)
    @After(value = "anyGetByIdServiceMethod() && args(id) && target(service)",
            argNames = "joinPoint, id, service")
    public void loggingGetByIdMethodAfter(JoinPoint joinPoint, Object id, Object service) {
        System.out.println("[INFO]: End method get by id " + service.getClass().getSimpleName());
       // System.out.println(" with id: " + id);
    }


    @Around(value = "anyGetByIdServiceMethod() && args(id) && target(service)",
            argNames = "proceedingJoinPoint, id, service")
    public Object logicForGetByIdMethod(ProceedingJoinPoint proceedingJoinPoint,  Object id, Object service) throws Throwable {
        System.out.print("[INFO]: AROUND Get by Id method called in " + service.getClass().getSimpleName());
        System.out.println(" with id: " + id);
        try {
            Object result = proceedingJoinPoint.proceed();
            return result;
        } catch (Throwable e) {
            System.out.println("[INFO]: AROUND EXCEPTION: " + e.getMessage());
            throw e;
        } finally {
            System.out.println("[INFO]: AROUND After finally ");

        }
    }

}
