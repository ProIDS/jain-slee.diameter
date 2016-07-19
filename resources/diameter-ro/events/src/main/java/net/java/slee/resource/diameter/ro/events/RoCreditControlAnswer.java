/*
 * JBoss, Home of Professional Open Source
 * Copyright 2011, Red Hat, Inc. and individual contributors
 * by the @authors tag. See the copyright.txt in the distribution for a
 * full listing of individual contributors.
 *
 * This is free software; you can redistribute it and/or modify it
 * under the terms of the GNU Lesser General Public License as
 * published by the Free Software Foundation; either version 2.1 of
 * the License, or (at your option) any later version.
 *
 * This software is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the GNU
 * Lesser General Public License for more details.
 *
 * You should have received a copy of the GNU Lesser General Public
 * License along with this software; if not, write to the Free
 * Software Foundation, Inc., 51 Franklin St, Fifth Floor, Boston, MA
 * 02110-1301 USA, or see the FSF site: http://www.fsf.org.
 */

package net.java.slee.resource.diameter.ro.events;

import net.java.slee.resource.diameter.base.events.avp.DiameterURI;
import net.java.slee.resource.diameter.base.events.avp.FailedAvp;
import net.java.slee.resource.diameter.base.events.avp.RedirectHostUsageType;
import net.java.slee.resource.diameter.cca.events.avp.CcSessionFailoverType;
import net.java.slee.resource.diameter.cca.events.avp.CostInformationAvp;
import net.java.slee.resource.diameter.cca.events.avp.CreditControlFailureHandlingType;
import net.java.slee.resource.diameter.ro.events.avp.RemainingBalance;

/**
 * Interface defining RoCreditControlAnswer message. Not all Rel. 8 AVPs are implemented - see indications below.
 * <br>
 * From the Diameter Ro Reference Point Protocol Details (3GPP TS 32.299 V8.25.0) specification:
 *
 * <pre>
 *  The Credit-Control-Answer (CCA) messages, indicated by the Command-Code field set to 272 is sent by the OCF to the CTF in order to reply to the CCR.
 *  The CCA message format is defined according to IETF RFC 4006 [402] as follows:
 *  <CCA> ::=  < Diameter Header: 272, PXY >
 *
 *        < Session-Id >
 *        { Result-Code }
 *        { Origin-Host }
 *        { Origin-Realm }
 *        { Auth-Application-Id }
 *        { CC-Request-Type }
 *        { CC-Request-Number }
 *        [ User-Name ]  NOT IMPLEMENTED YET
 *        [ CC-Session-Failover ]
 *        [ CC-Sub-Session-Id ]  NOT IMPLEMENTED YET
 *        [ Acct-Multi-Session-Id ]  NOT IMPLEMENTED YET
 *        [ Origin-State-Id ]  NOT IMPLEMENTED YET
 *        [ Event-Timestamp ]  NOT IMPLEMENTED YET
 *        [ Granted-Service-Unit ]  NOT IMPLEMENTED YET
 *        *[ Multiple-Services-Credit-Control ]
 *        [ Cost-Information]
 *        [ Low-Balance-Indication ]  NOT IMPLEMENTED YET
 *        [ Remaining-Balance ]
 *        [ Final-Unit-Indication ]  NOT IMPLEMENTED YET
 *        [ Check-Balance-Result ]  NOT IMPLEMENTED YET
 *        [ Credit-Control-Failure-Handling ]
 *        [ Direct-Debiting-Failure-Handling ]  NOT IMPLEMENTED YET
 *        [ Validity-Time]  NOT IMPLEMENTED YET
 *        *[ Redirect-Host]
 *        [ Redirect-Host-Usage ]
 *        [ Redirect-Max-Cache-Time ]
 *        *[ Proxy-Info ]
 *        *[ Route-Record ]
 *        *[ Failed-AVP ]
 *        [ Service-Information ]
 *        *[ AVP ]
 * </pre>
 * 
 * @author <a href="mailto:baranowb@gmail.com"> Bartosz Baranowski </a>
 * @author <a href="mailto:brainslog@gmail.com"> Alexandre Mendonca </a>
 * @author <a href="mailto:grzegorz.figiel@pro-ids.com"> Grzegorz Figiel [ProIDS] </a>
 */
public interface RoCreditControlAnswer extends RoCreditControlMessage {

  /**
   * Returns true if the Result-Code AVP is present in the message.
   */
  boolean hasResultCode();

  /**
   * Returns the value of the Result-Code AVP, of type Unsigned32. Use
   * {@link #hasResultCode()} to check the existence of this AVP.
   * 
   * @return the value of the Result-Code AVP
   * @throws IllegalStateException
   *             if the Result-Code AVP has not been set on this message
   */
  long getResultCode();

  /**
   * Sets the value of the Result-Code AVP, of type Unsigned32.
   * 
   * @throws IllegalStateException
   *             if setResultCode has already been called
   */
  void setResultCode(long resultCode);

  /**
   * Returns the value of the CC-Session-Failover AVP, of type Enumerated.
   * 
   * @return
   */
  CcSessionFailoverType getCcSessionFailover();

  /**
   * Sets the value of the CC-Session-Failover AVP, of type Enumerated.
   * 
   * @param ccSessionFailover
   * @throws IllegalStateException
   */
  void setCcSessionFailover(CcSessionFailoverType ccSessionFailover) throws IllegalStateException;

  /**
   * Returns true if the CC-Session-Failover AVP is present in the message.
   * 
   * @return
   */
  boolean hasCcSessionFailover();

    /**
     * Returns the value of the Cost-Information AVP, of type Grouped.
     *
     * @return
     */
    CostInformationAvp getCostInformation();

    /**
     * Sets the value of the Cost-Information AVP, of type Grouped.
     *
     * @param costInformation
     * @throws IllegalStateException
     */
    void setCostInformation(CostInformationAvp costInformation) throws IllegalStateException;

    /**
     * Returns true if the Cost-Information AVP is present in the message.
     *
     * @return
     */
    boolean hasCostInformation();

    /**
     * Returns the value of the Remaining-Balance AVP, of type Grouped.
     *
     * @return
     */
    RemainingBalance getRemainingBalance();

    /**
     * Sets the value of the Remaining-Balance AVP, of type Grouped.
     *
     * @param remainingBalance
     * @throws IllegalStateException
     */
    void setRemainingBalance(RemainingBalance remainingBalance) throws IllegalStateException;

    /**
     * Returns true if the Remaining-Balance AVP is present in the message.
     *
     * @return
     */
    boolean hasRemainingBalance();

    /**
   * Returns the value of the Credit-Control-Failure-Handling AVP, of type
   * Enumerated.
   * 
   * @return
   */
  CreditControlFailureHandlingType getCreditControlFailureHandling();

  /**
   * Sets the value of the Credit-Control-Failure-Handling AVP, of type
   * Enumerated.
   * 
   * @param creditControlFailureHandling
   * @throws IllegalStateException
   */
  void setCreditControlFailureHandling(CreditControlFailureHandlingType creditControlFailureHandling) throws IllegalStateException;

  /**
   * Returns true if the Credit-Control-Failure-Handling AVP is present in the
   * message.
   * 
   * @return
   */
  boolean hasCreditControlFailureHandling();

  /**
   * Returns the set of Redirect-Host AVPs.
   * 
   * @return
   */
  DiameterURI[] getRedirectHosts();

  /**
   * Sets a single Redirect-Host AVP in the message, of type DiameterURI.
   * 
   * @param redirectHost
   * @throws IllegalStateException
   */
  void setRedirectHost(DiameterURI redirectHost) throws IllegalStateException;

  /**
   * Sets the set of Redirect-Host AVPs, with all the values in the given
   * array.
   * 
   * @param redirectHosts
   * @throws IllegalStateException
   */
  void setRedirectHosts(DiameterURI[] redirectHosts) throws IllegalStateException;

  /**
   * Returns the value of the Redirect-Host-Usage AVP, of type Enumerated.
   * 
   * @return
   */
  RedirectHostUsageType getRedirectHostUsage();

  /**
   * Sets the value of the Redirect-Host-Usage AVP, of type Enumerated.
   * 
   * @param redirectHostUsage
   * @throws IllegalStateException
   */
  void setRedirectHostUsage(RedirectHostUsageType redirectHostUsage) throws IllegalStateException;

  /**
   * Returns true if the Redirect-Host-Usage AVP is present in the message.
   * 
   * @return
   */
  boolean hasRedirectHostUsage();

  /**
   * Returns the value of the Redirect-Max-Cache-Time AVP, of type Unsigned32.
   * 
   * @return
   */
  long getRedirectMaxCacheTime();

  /**
   * Sets the value of the Redirect-Max-Cache-Time AVP, of type Unsigned32.
   * 
   * @param redirectMaxCacheTime
   * @throws IllegalStateException
   */
  void setRedirectMaxCacheTime(long redirectMaxCacheTime) throws IllegalStateException;

  /**
   * Returns true if the Redirect-Max-Cache-Time AVP is present in the
   * message.
   * 
   * @return
   */
  boolean hasRedirectMaxCacheTime();

  /**
   * Returns the set of Failed-AVP AVPs.
   * 
   * @return
   */
  FailedAvp[] getFailedAvps();

  /**
   * Sets a single Failed-AVP AVP in the message, of type Grouped.
   * 
   * @param failedAvp
   * @throws IllegalStateException
   */
  void setFailedAvp(FailedAvp failedAvp) throws IllegalStateException;

  /**
   * Sets the set of Failed-AVP AVPs, with all the values in the given array.
   * 
   * @param failedAvps
   * @throws IllegalStateException
   */
  void setFailedAvps(FailedAvp[] failedAvps) throws IllegalStateException;

}
