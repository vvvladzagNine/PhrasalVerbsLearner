import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

public class PStart implements answ {
    static final int WIDTH = 500;
    static final int HEIGHT = 300;
    static JFrame frame;
    static JPanel panel1;
    static JPanel panel11;
    static ImagePanel panel12;
    static JPanel panel13;
    static JPanel mainPanel;
    static JLabel label;
    static JButton next;
    static JLabel dididi;
    static JLabel field;
    static JButton answerButtorn;

    static String verb;
    static String preposition;

    // Verbs buttons
    static JButton[] verbButtons;

    // Preposition buttons
    static JButton[] prepButtons;

    // Questions
    static ArrayList<Question> questions;

    // Verbs
    static ArrayList<String> verbs;

    //Prepositions
    static ArrayList<String> prepositions;

    //
    static ArrayList<Boolean> passedQuestions;



    static Question currentQuestion;

    static JPanel panelLow;

    public static void main(String[] args) {
        verb="";
        preposition = "";

        frame = new JFrame("PV Learner");
        frame.setSize(WIDTH,HEIGHT);
        label = new JLabel("leave a place running");
        label.setForeground(new Color(90,90,90));
        label.setFont(new Font("SansSerif",Font.ITALIC,20));
        field = new JLabel("your answer !");field.setFont(new Font("Times New Roman",Font.PLAIN,30));
        answerButtorn = new JButton("Answer !");answerButtorn.addActionListener(new AnswerListener());

        mainPanel = new JPanel();
        panel1 = new JPanel();
        panel11 = new JPanel();
        panel12 = new ImagePanel();panel12.setPreferredSize(new Dimension(400,240));
        panel13 = new JPanel();
        panelLow=new JPanel();

        next = new JButton(" >>>");next.setEnabled(false);
        next.addActionListener(new ButtonNextListener());
        dididi = new JLabel("no answer"); dididi.setForeground(new Color(23,27,236));

        BufferedImage image;


        BoxLayout boxLayout = new BoxLayout(mainPanel,BoxLayout.Y_AXIS);mainPanel.setLayout(boxLayout);
        BoxLayout boxLayout1  = new BoxLayout(panel11,BoxLayout.Y_AXIS);panel11.setLayout(boxLayout1);
        BoxLayout boxLayout3  = new BoxLayout(panel13,BoxLayout.Y_AXIS);panel13.setLayout(boxLayout3);
        FlowLayout fl = new FlowLayout();panel1.setLayout(fl);
        FlowLayout fl1 = new FlowLayout();panelLow.setLayout(fl1);
        panelLow.add(dididi);
        panelLow.add(answerButtorn);
        panelLow.add(next);

        verbButtons = new JButton[7];
        prepButtons = new JButton[7];
        for(int i=0;i<7;i++){
            String text = "verb" + i;
            String text1 = "prep" + i;
            verbButtons[i] = new JButton(text);
            panel11.add(verbButtons[i]);
            prepButtons[i] = new JButton(text1);
            panel13.add(prepButtons[i]);

        }
        initializeQuestions();
        addingListeners();
        addingVerbs();
        addingPrepositions();
        initPassed();



        panel1.add(panel11);
        panel1.add(panel12);
        panel1.add(panel13);
        mainPanel.add(panel1);

        JPanel labelPanel = new JPanel();
        labelPanel.add(label);
        mainPanel.add(labelPanel);

        JPanel fieldPanel = new JPanel();
        fieldPanel.add(field);
        mainPanel.add(fieldPanel);
        mainPanel.add(panelLow);

        frame.getContentPane().add(mainPanel);


        frame.pack();
        frame.setVisible(true);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        int t = (int)(Math.random() * questions.size());
        currentQuestion=questions.get(t);
        passedQuestions.set(t,false);
        setQuestion(currentQuestion);

        frame.setLocationRelativeTo(null);



    }

    static void addingListeners(){
        verbButtons[0].addActionListener(new ButtonListenerV0());
        verbButtons[1].addActionListener(new ButtonListenerV1());
        verbButtons[2].addActionListener(new ButtonListenerV2());
        verbButtons[3].addActionListener(new ButtonListenerV3());
        verbButtons[4].addActionListener(new ButtonListenerV4());
        verbButtons[5].addActionListener(new ButtonListenerV5());
        verbButtons[6].addActionListener(new ButtonListenerV6());

        prepButtons[0].addActionListener(new ButtonListenerP0());
        prepButtons[1].addActionListener(new ButtonListenerP1());
        prepButtons[2].addActionListener(new ButtonListenerP2());
        prepButtons[3].addActionListener(new ButtonListenerP3());
        prepButtons[4].addActionListener(new ButtonListenerP4());
        prepButtons[5].addActionListener(new ButtonListenerP5());
        prepButtons[6].addActionListener(new ButtonListenerP6());
    }
    static void addingVerbs(){
        System.out.println("\n\nVerbs:");
        verbs = new ArrayList<>();
        verbs.add("fall");
        verbs.add("flow");
        verbs.add("act");
        verbs.add("agree");
        verbs.add("appeal");
        verbs.add("back");
        verbs.add("block");
        verbs.add("hold");
        verbs.add("keep");
        verbs.add("pick");
        verbs.add("work");
        verbs.add("turn");
        verbs.add("talk");
        verbs.add("tell");
        verbs.add("set");

        for (Question q: questions) {
            String v = q.getVerb();
            boolean flag = true;
            for(String vb : verbs ){
                if(v.equals(vb)){
                    flag=false;
                    break;
                }
            }
            if(flag){
                verbs.add(v);
                System.out.println(v);
            }
        }
        for(String v: verbs){
            System.out.println(v);
        }
    }
    static void addingPrepositions(){
        System.out.println("\n\nPrepositions:");
        prepositions = new ArrayList<>();
        prepositions.add("with");
        prepositions.add("at");
        prepositions.add("from");
        prepositions.add("into");
        prepositions.add("during");
        prepositions.add("towards");
        prepositions.add("forward");
        prepositions.add("upon");
        prepositions.add("of");
        prepositions.add("to");
        prepositions.add("in");
        prepositions.add("for");
        prepositions.add("on");
        prepositions.add("by");
        prepositions.add("about");
        prepositions.add("through");
        prepositions.add("over");
        prepositions.add("before");
        prepositions.add("under");
        prepositions.add("within");
        prepositions.add("along");
        prepositions.add("behind");
        prepositions.add("up");
        prepositions.add("out");
        prepositions.add("down");
        prepositions.add("around");
        prepositions.add("off");
        prepositions.add("above");
        prepositions.add("near");

        for (Question q: questions) {
            String p = q.getPreposition();
            boolean flag = true;
            for(String pr : prepositions ){
                if(p.equals(pr)){
                    flag=false;
                    break;
                }
            }
            if(flag){
                prepositions.add(p);
                System.out.println(p);
            }
        }
        for(String p : prepositions){
            System.out.println(p);
        }

    }
    static void initializeQuestions(){
        questions=new ArrayList<>();
        questions.add(new Question("look for","To search","lookFor.jpg"));
        questions.add(new Question("wake up","To rise from the bed","wakeUp.jpg"));
        questions.add(new Question("make up","To imagine ","makeUp.jpg"));
        questions.add(new Question("look up","To find smt in reference","lookUp.jpg"));
        questions.add(new Question("put on","To dress ","putOn.jpg"));
        questions.add(new Question("take off","To undress","takeOff.jpg"));
        questions.add(new Question("find out","To learn, to discover","findOut.jpg"));
        questions.add(new Question("figure out","To comprehend","figureOut.jpg"));
        questions.add(new Question("abide by","To follow rules","abideBy.jpg"));
        questions.add(new Question("account for","To explain","accountFor.jpg"));
        questions.add(new Question("act on","To start to do snt because you have received \nthe information","actOn.png"));
        questions.add(new Question("act out","To show how things has happened","actOut.jpg"));
        questions.add(new Question("advice against","Recommend not to do","adviceAgainst.jpg"));
        questions.add(new Question("appeal to","To be interesting","appealFor.jpg"));
        questions.add(new Question("act up","When someone behaves badly","actUp.jpg"));
        questions.add(new Question("apply for","To make a request","applyFor.jpg"));
        questions.add(new Question("back away","To move backwards being afraid","backAway.jpg"));
        questions.add(new Question("back down","To go away, to give up","backDown.jpg"));
        questions.add(new Question("back up","To support someone","backUp.jpg"));
        questions.add(new Question("bank on","To found hopes on someone","bankOn.jpg"));

       // questions.add(new Question("black out","To lose consciousness","default.jpg"));
       // questions.add(new Question("block off","To divide using a barrier","default.jpg"));
       // questions.add(new Question("blow up","To explode","default.jpg"));
       // questions.add(new Question("boot up","To load the OS","default.jpg"));
       // questions.add(new Question("break up","To end a relationship","default.jpg"));
       // questions.add(new Question("break into","To enter using force","default.jpg"));
       // questions.add(new Question("break away","To move away from crowd","default.jpg"));
       // questions.add(new Question("break out","To being suddenly","default.jpg"));
       // questions.add(new Question("bring up","To rise a children","default.jpg"));
       // questions.add(new Question("bump into","To meet somebody unexpectedly","default.jpg"));
       // questions.add(new Question("burn out","When a thing stops working","default.jpg"));
       // questions.add(new Question("call back","To return a phone call","default.jpg"));
       // questions.add(new Question("call off","To cancel","default.jpg"));
       // questions.add(new Question("calm down","To became not angry","default.jpg"));
       // questions.add(new Question("carry on","To continue","default.jpg"));
       // questions.add(new Question("carry out","To complete smt as it has been planned","default.jpg"));
       // questions.add(new Question("check in","To register somewhere","default.jpg"));
       // questions.add(new Question("check out","To leave the hotel","default.jpg"));
       // questions.add(new Question("clam up","To deny to speak","default.jpg"));
       // questions.add(new Question("come across","To find something accidentally","default.jpg"));
       // questions.add(new Question("come forward","To step in front","default.jpg"));
       // questions.add(new Question("count on","To rely on someone","default.jpg"));
       // questions.add(new Question("cut out","To stop doing something","default.jpg"));
       // questions.add(new Question("deal with","To handle a problem","default.jpg"));
       // questions.add(new Question("die down","To become weaker","default.jpg"));
       // questions.add(new Question("drag on","When some process continues longer \nthan it was expected","default.jpg"));
       // questions.add(new Question("drag into","To make smb participle into against \ntheir will","default.jpg"));
       // questions.add(new Question("draw up","To compose a document","default.jpg"));
       // questions.add(new Question("ease off","To decrease the intensity of something","default.jpg"));
       // questions.add(new Question("egg on","To encourage, to support","default.jpg"));
       // questions.add(new Question("embark on","To do smt challenging","default.jpg"));
       // questions.add(new Question("end up","To cease in a certain way","default.jpg"));
       // questions.add(new Question("fall about","To burst out laughing","default.jpg"));
       // questions.add(new Question("fall backOn","To rely on smt","default.jpg"));
       // questions.add(new Question("fall behind","To miss the deadline","default.jpg"));
       // questions.add(new Question("fall for","To be misted/deceived","default.jpg"));
       // questions.add(new Question("fall out","To stop to being friends","default.jpg"));
       // questions.add(new Question("fall through","To fail","default.jpg"));
       // questions.add(new Question("fall to","To be chosen to do something","default.jpg"));
       // questions.add(new Question("fit in","To adapt","default.jpg"));
       // questions.add(new Question("fizzle out","To fade away","default.jpg"));
       // questions.add(new Question("freak out","To panic, to go mad","default.jpg"));
       // questions.add(new Question("fuss over","To care to mush","default.jpg"));
       // questions.add(new Question("get alongWith","To have good relationships","default.jpg"));
       // questions.add(new Question("get at","To attack or criticize","default.jpg"));
       // questions.add(new Question("get away","To escape without any consequences","default.jpg"));
    }
    static void initPassed(){
        passedQuestions = new ArrayList<>();
        for(Question q: questions){
            boolean b =true;
            passedQuestions.add(b);
        }
    }

    //
    // Set Question
    //
    static void setQuestion(Question current){
        label.setText(current.getDescription());
        panel12.setImage(current.getPicture());
        panel12.setPreferredSize(new Dimension(panel12.getImageWidth(),panel12.getImageHeight()));
        int rightV = (int)(Math.random() * 7);
        int rightP = (int)(Math.random() * 7);
        verbButtons[rightV].setText(current.getVerb());
        prepButtons[rightP].setText(current.getPreposition());
        for(int i=0;i<7;i++){
            if(i!=rightV){
                int v;
                boolean tf;
                do{
                    tf = true;
                    v = (int)(Math.random() * verbs.size());
                    String theVerb = verbs.get(v);
                    for(JButton vb : verbButtons){
                        String aVerb = vb.getText();
                        if(theVerb.equals(aVerb)){
                            tf=false;
                            break;
                        }
                    }

                }while (!tf);
                verbButtons[i].setText(verbs.get(v));
            }
            if(i!=rightP){
                //int p= (int)(Math.random() * prepositions.size());
                //prepButtons[i].setText(prepositions.get(p));
                int p;
                boolean tf;
                int a;
                do{
                    tf = true;
                    p = (int)(Math.random() * prepositions.size());
                    String thePerp = prepositions.get(p);

                    for(JButton pb : prepButtons){
                        String aPerp = pb.getText();
                        if(thePerp.equals(aPerp)){
                            tf=false;
                            a=5;
                            break;
                        }
                    }

                }while (!tf);
                prepButtons[i].setText(prepositions.get(p));
            }
        }

        dididi.setText("no answer");
        dididi.setForeground(new Color(23,27,236));
        next.setEnabled(false);
        frame.pack();



    }

    /**
     *
     * @author vvladzag
     */
    static void answer(){
        String ans = field.getText();
        if(ans.equals(currentQuestion.getAnswer())){
            dididi.setText("You are right!");
            dididi.setForeground(new Color(2,170,13));
            next.setEnabled(true);
        }
        else {
            dididi.setText("You are wrong!");
            dididi.setForeground(new Color(200,25,40));

        }
    }

    //
    // Next question
    //
    static class ButtonNextListener implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e) {
            boolean tf;
            int a;
            boolean check = false;
            for(boolean ch : passedQuestions){
                if(ch){
                    check=ch;
                    break;
                }
            }
            if(!check){
                for(int j=0;j<passedQuestions.size();j++){
                    passedQuestions.set(j,true);
                }
            }
            do {

                a = (int) (Math.random() * questions.size());
                tf=passedQuestions.get(a);

            }while (!tf);

            passedQuestions.set(a,false);
            currentQuestion = questions.get(a);

            setQuestion(currentQuestion);
        }
    }

    //
    // Answering
    //
    static class AnswerListener implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            answer();
        }
    }
    static class ButtonListenerV0 implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            verb = verbButtons[0].getText();
            field.setText(verb + " " + preposition);
        }
    }
    static class ButtonListenerV1 implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            verb = verbButtons[1].getText();
            field.setText(verb + " " + preposition);
        }
    }
    static class ButtonListenerV2 implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            verb = verbButtons[2].getText();
            field.setText(verb + " " + preposition);
        }
    }
    static class ButtonListenerV3 implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            verb = verbButtons[3].getText();
            field.setText(verb + " " + preposition);
        }
    }
    static class ButtonListenerV4 implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            verb = verbButtons[4].getText();
            field.setText(verb + " " + preposition);
        }
    }
    static class ButtonListenerV5 implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            verb = verbButtons[5].getText();
            field.setText(verb + " " + preposition);
        }
    }
    static class ButtonListenerV6 implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            verb = verbButtons[6].getText();
            field.setText(verb + " " + preposition);
        }
    }


    static class ButtonListenerP0 implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            preposition = prepButtons[0].getText();
            field.setText(verb + " " + preposition);
        }
    }
    static class ButtonListenerP1 implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            preposition = prepButtons[1].getText();
            field.setText(verb + " " + preposition);
        }
    }
    static class ButtonListenerP2 implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            preposition = prepButtons[2].getText();
            field.setText(verb + " " + preposition);
        }
    }
    static class ButtonListenerP3 implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            preposition = prepButtons[3].getText();
            field.setText(verb + " " + preposition);
        }
    }
    static class ButtonListenerP4 implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            preposition = prepButtons[4].getText();
            field.setText(verb + " " + preposition);
        }
    }
    static class ButtonListenerP5 implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            preposition = prepButtons[5].getText();
            field.setText(verb + " " + preposition);
        }
    }
    static class ButtonListenerP6 implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            preposition = prepButtons[6].getText();
            field.setText(verb + " " + preposition);
        }
    }
}
