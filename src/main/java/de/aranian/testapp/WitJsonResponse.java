/*
* WitJsonResponse.java
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
public class WitJsonResponse
{
  private String msg_id;
  private String msg_body;
  private Outcome outcome;



  public WitJsonResponse()
  {

  }



  public String getMsg_id()
  {
    return msg_id;
  }



  public String getMsg_body()
  {
    return msg_body;
  }



  public Outcome getOutcome()
  {
    return outcome;
  }



  public void setMsg_id(String msg_id)
  {
    this.msg_id = msg_id;
  }



  public void setMsg_body(String msg_body)
  {
    this.msg_body = msg_body;
  }



  public void setOutcome(Outcome outcome)
  {
    this.outcome = outcome;
  }
}