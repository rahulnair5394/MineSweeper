package com.bitwise.kata;

/**
 * Created by rahuln on 7/22/2016.
 */
public enum HintFieldType implements Type{
    BOMB{
        public char type(){
            return '*';
        }
    },
    ZERO{
        public char type(){
            return '0';
        }
    },ONE{
        public char type(){
            return '1';
        }
    },TWO{
        public char type(){
            return '2';
        }
    },THREE{
        public char type(){
            return '3';
        }
    },FOUR{
        public char type(){
            return '4';
        }
    },FIVE{
        public char type(){
            return '5';
        }
    },SIX{
        public char type(){
            return '6';
        }
    },SEVEN{
        public char type(){
            return '7';
        }
    },EIGHT{
        public char type(){
            return '8';
        }
    };
}