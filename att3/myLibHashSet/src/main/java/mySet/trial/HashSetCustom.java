package mySet.trial;

public class HashSetCustom<E>{


    private HashMapCustom<E, Object> hashMapCustom;

    public HashSetCustom(){
        hashMapCustom = new HashMapCustom<>();
    }


    public void add(E value){
        hashMapCustom.put(value, null);
    }


    public boolean contains(E obj){
        return hashMapCustom.contains(obj) != null;
    }

    /**
     * Method displays all objects in setCustom.
     * insertion order is not guaranteed, for maintaining insertion order refer LinkedHashSet.
     */
    public void display(){
        hashMapCustom.displaySet();
    }

    /**
     * Method removes object from setCustom.
     * @param obj
     */
    public boolean remove(E obj){
        return hashMapCustom.remove(obj);
    }

}