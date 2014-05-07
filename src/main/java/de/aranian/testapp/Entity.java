/*
* Entity.java
*
* Created on May 7, 2014
*
* This file is property of the medisite Systemhaus GmbH.
* (c) Copyright medisite Systemhaus GmbH.
* All rights reserved.
*/
package de.aranian.testapp;



/**
 *
 *
 * @author sl
 * @since  0.1
 */
public class Entity
{
  private float end;
  private float start;
  private String value;
  private String body;
  private boolean suggested;



  public Entity()
  {

  }



  public float getEnd()
  {
    return end;
  }



  public float getStart()
  {
    return start;
  }



  public String getValue()
  {
    return value;
  }



  public String getBody()
  {
    return body;
  }



  public boolean isSuggested()
  {
    return suggested;
  }



  public void setEnd(float end)
  {
    this.end = end;
  }



  public void setStart(float start)
  {
    this.start = start;
  }



  public void setValue(String value)
  {
    this.value = value;
  }



  public void setBody(String body)
  {
    this.body = body;
  }



  public void setSuggested(boolean suggested)
  {
    this.suggested = suggested;
  }
}