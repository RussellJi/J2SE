package generics.test;

class Pair<T>{
    private T firstname;
    private T lastname;
    Pair(T firstname,T lastname){
        this.firstname = firstname;
        this.lastname  = lastname;
    }
    T getFirstname(){
        return this.firstname;
    }
    T getLastname(){
        return this.lastname;
    }
    static <K>Pair<K> create(K firstname,K lastname) {
        return new Pair<K>(firstname,lastname);
    }
}