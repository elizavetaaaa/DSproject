package com.company;


import java.util.*;

public class Dict {

    Main myMain = new Main();

    HashMap<Integer, Question> dict = new HashMap<Integer, Question>();//my database
    static List<Integer> keys;
    int maks = 0;
    static int index = 0;
    static Object Question;
    public Object Answer;


    public Dict() {
        dict.put(0, new Question("<html>What Indian city is the capital <br> of two states?<br><br/>a) Chandigarh<br/>b) Mumbai<br/>c) Kolkata <br/>d) Chennai</html>", "a"));
        dict.put(1, new Question("<html>How many countries border India?<br/><br/>a) 7<br/>b) 14<br/>c) 7<br/>d) 8</html>", "c"));
        dict.put(2, new Question("<html>What is the capital of Gujarat?<br/> <br/>a) Peshawar<br/>b)  Gandhinagar<br/>c)Bhopal <br/>d)Mumbai</html>", "b"));
        dict.put(3, new Question("<html>IT capital of India? <br/> <br/>a)Bangalor<br/>b)Delhi<br/>c)Mumbai<br/>d)Kerala</html>", "a"));
        dict.put(4, new Question("<html>Who was the president of India in 2009?<br/> <br/>a)Indira Gandhi<br/>b)Govinda Singh<br/>c)Jawaharlal Nehru<br/>d)Smt. Pratibha Devisingh Patil</html>", "d"));
        dict.put(5, new Question("<html>What is India’s smallest state?<br/> <br/>a)Kerala<br/>b)Puducherry<br/>c)Uttar Pradesh<br/>d)Goa</html>", "d"));
        dict.put(6, new Question("<html>Which of these bodies of <br/> water does not border India?<br/> <br/>a)the Indian Ocean<br/>b)the Arabian Sea<br/>c)the Red Sea<br/>d)the Bay of Bengal</html>", "c"));
        dict.put(7, new Question("<html>Delhi is located along what river? <br/><br/>a)the Ganges<br/>b)the Brahmaputra<br/>c)the Nile<br/>d)the Yamuna</html>", "d"));
        dict.put(8, new Question("<html>Which of these is not a river of India?<br/> <br/>a)Mekong<br/>b)Yamuna<br/>c)Ganges<br/>d)Brahmaputra</html>", "a"));
        dict.put(9, new Question("<html>Capital of yoga is ...<br/> <br/>a)Delhi<br/>b)Rishikesh<br/>c)Lakhnau<br/>d)Varanasi</html>", "b"));
        keys = new ArrayList<>(dict.keySet());
        Collections.shuffle(keys);//mix ids of dict
    }


    public  Question getQuestion(Integer id){
        return dict.get(id);
    }

    void quiz(){//возникновение нового вопроса на title

        Main.input.setText("");
        int key = keys.get(index);
        Question q = dict.get(key);
        String question  = q.getQuestion();
        Main.title.setText(question);

    }

}