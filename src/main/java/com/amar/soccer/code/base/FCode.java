package com.amar.soccer.code.base;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(ElementType.FIELD)  
@Retention(RetentionPolicy.RUNTIME) 
public @interface FCode
{
	public int index() default 1;  //从1开始，同一个类不能重复
}
