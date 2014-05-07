/*
* Outcome.java
*
* Created on May 7, 2014
*
* This file is property of the medisite Systemhaus GmbH.
* (c) Copyright medisite Systemhaus GmbH.
* All rights reserved.
*/
package de.aranian.testapp;

import java.util.Map;



/**
 *
 *
 * @author sl
 * @since  0.1
 */
public class Outcome
{
  private String intent;
  private Map<String, Entity> entities;
  private float confidence;




  public Outcome()
  {

  }



  public String getIntent()
  {
    return intent;
  }



  public Map<String, Entity> getEntities()
  {
    return entities;
  }



  public float getConfidence()
  {
    return confidence;
  }



  public void setIntent(String intent)
  {
    this.intent = intent;
  }



  public void setEntities(Map<String, Entity> entities)
  {
    this.entities = entities;
  }



  public void setConfidence(float confidence)
  {
    this.confidence = confidence;
  }
}