package general.test;

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
    static Pair<T> create(T firstname,T lastname) {
        return new Pair<T>(T firstname,T lastname);
    }
}