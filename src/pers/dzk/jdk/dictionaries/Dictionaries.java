package pers.dzk.jdk.dictionaries;

public class Dictionaries {

    private final static char[] UPPER_CASE = new char[26];
    private final static char[] LOWER_CASE = new char[26];
    private final static char[] NUMBER = new char[10];
    private final static char[] SYMBOL = new char[]{'~','!','@','#','$','%','^','&','*','(',')','-','_','=','+','[','{',']','}','\\','|',';',':','\'','"',',','<','.','>','/','?'};
    private final static char[]  CHINESE_CHARACTERS = new char['\u9fa5'-'\u4e00'+1];    //\u9fa5-\u4e00内全是汉字，所以拿大的-小的再+1就是了。比如3到6内是汉字，则3，4，5，6是汉字，即汉字数量为6-3+1。
    static {
        int index = 0;
        for (char i = 65;i <= 90;i++,index++){
            UPPER_CASE[index] = i;
        }
        index = 0;
        for (char i = 97;i <= 122;i++,index++){
            LOWER_CASE[index] = i;
        }
        index = 0;
        for (char i = 48;i <= 57;i++,index++){
            NUMBER[index] = i;
        }
        index = 0;
        for (char i = '\u4e00';i <= '\u9fa5';i++,index++){
            CHINESE_CHARACTERS[index] = i;
        }
        index = 0;
    }

    /**
     * 获取汉字
     * @return
     */
    public static char[] getChineseCharacters(){
        return CHINESE_CHARACTERS;
    }
    /**
     * 获取大写字母
     * @return
     */
    public static char[] getUpperCase() {
        return UPPER_CASE;
    }

    /**
     * 获取小写字母
     * @return
     */
    public static char[] getLowerCase() {
        return LOWER_CASE;
    }

    /**
     * 获取阿拉伯数字
     * @return
     */
    public static char[] getNumber() {
        return NUMBER;
    }

    /**
     * 获取特殊符号
     * @return
     */
    public static char[] getSymbol() {
        return SYMBOL;
    }

    /**
     * 获取大小写字母
     * @return
     */
    public static char[] getLetter(){
        char[] array = new char[LOWER_CASE.length*2];
        for (int i = 0; i < LOWER_CASE.length; i++){
                array[i] = UPPER_CASE[i];
        }
        for (int i = LOWER_CASE.length; i < array.length; i++){
            array[i] = LOWER_CASE[i- LOWER_CASE.length];
        }
        return array;
    }

    /**
     * 获取所有键
     * @return
     */
    public static char[] getKey(){
        char[] array = new char[LOWER_CASE.length*2+ NUMBER.length+ SYMBOL.length];
        char[] letter = getLetter();
        for (int i = 0;i < letter.length;i ++){
            array[i] = letter[i];
        }
        for (int i = letter.length; i < letter.length+ NUMBER.length; i++){
            array[i] = NUMBER[i-letter.length];
        }
        for (int i = letter.length+ NUMBER.length; i < array.length; i++){
            array[i] = SYMBOL[i-letter.length- NUMBER.length];
        }
        return array;
    }

    /**
     * 获取所有字母和数字
     * @return
     */
    public static char[] getLetterAndNumber(){
        char[] letter = getLetter();
        char[] array = new char[letter.length+ NUMBER.length];
        for (int i = 0;i < letter.length;i++){
            array[i] = letter[i];
        }
        for (int i = letter.length;i < array.length;i++){
            array[i] = NUMBER[i -letter.length];
        }
        return array;
    }

    /**
     * 获取小写字母和数字
     * @return
     */
    public static char[] getLowerCaseAndNumber(){
        char[] array = new char[LOWER_CASE.length+ NUMBER.length];
        for (int i = 0; i < LOWER_CASE.length; i++){
            array[i] = LOWER_CASE[i];
        }
        for (int i = LOWER_CASE.length; i < array.length; i++){
            array[i] = NUMBER[i- LOWER_CASE.length];
        }
        return array;
    }

}
