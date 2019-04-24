package com.maze.enu;

import com.maze.util.Constant;

public enum Level {
	imput	{
        @Override
        public String getDescription() {
            return Constant.INPUT1;
        }
    },
	largeInput{
        @Override
        public String getDescription() {
            return Constant.INPUT2;
        }
    },
	mediumInput{
        @Override
        public String getDescription() {
            return Constant.INPUT3;
        }
    },
	smallInput{
        @Override
        public String getDescription() {
            return Constant.INPUT4;
        }
    },
	smallWInput{
        @Override
        public String getDescription() {
            return Constant.INPUT4;
        }
    },
	sparseLarge{
        @Override
        public String getDescription() {
            return Constant.INPUT5;
        }
    },
    sparseMedium{
        @Override
        public String getDescription() {
            return Constant.INPUT6;
        }
    };


	public abstract String getDescription();
	 
	
	 

};