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

package net.java.slee.resource.diameter.cxdx.events;

import net.java.slee.resource.diameter.base.events.DiameterMessage;
import net.java.slee.resource.diameter.base.events.avp.AuthSessionStateType;
import net.java.slee.resource.diameter.base.events.avp.DiameterIdentity;
import net.java.slee.resource.diameter.base.events.avp.ProxyInfoAvp;
import net.java.slee.resource.diameter.base.events.avp.VendorSpecificApplicationIdAvp;
import net.java.slee.resource.diameter.cxdx.events.avp.OriginatingRequest;
import net.java.slee.resource.diameter.cxdx.events.avp.SessionPriority;
import net.java.slee.resource.diameter.cxdx.events.avp.UserAuthorizationType;
import net.java.slee.resource.diameter.cxdx.events.avp.SupportedFeaturesAvp;

/**
 * <pre>
 *
 * 3GPP TS 29.229 version 12.7.0 Release 12
 *
 * <b>6.1.5 Location-Info-Request (LIR) Command</b>
 * The Location-Info-Request (LIR) command, indicated by the Command-Code field set to 302 and
 * the 'R' bit set in the Command Flags field, is sent by a Diameter Multimedia client to a
 * Diameter Multimedia server in order to request name of the server that is currently serving
 * the user.
 *
 * Message Format
 * <Location-Info-Request> ::=   < Diameter Header: 302, REQ, PXY, 16777216 >
 *                         < Session-Id >
 *                         { Vendor-Specific-Application-Id }
 *                         { Auth-Session-State }
 *                         { Origin-Host }
 *                         { Origin-Realm }
 *                         [ Destination-Host ]
 *                         { Destination-Realm }
 *                         [ Originating-Request ]
 *                         [ OC-Supported-Features ]    //Draft
 *                        *[ Supported-Features ]
 *                         { Public-Identity }
 *                         [ User-Authorization-Type ]
 *                         [ Session-Priority ]         //R12
 *                        *[ AVP ]
 *                        *[ Proxy-Info ]
 *                        *[ Route-Record ]
 * </pre>
 *
 * @author <a href="mailto:brainslog@gmail.com"> Alexandre Mendonca </a>
 * @author <a href="mailto:baranowb@gmail.com"> Bartosz Baranowski </a>
 */
public interface LocationInfoRequest extends DiameterMessage {

  public static final int COMMAND_CODE = 302;

  /**
   * Returns true if the Vendor-Specific-Application-Id AVP is present in the
   * message.
   */
  boolean hasVendorSpecificApplicationId();

  /**
   * Returns the value of the Vendor-Specific-Application-Id AVP, of type
   * Grouped.
   *
   * @return the value of the Vendor-Specific-Application-Id AVP or null if it
   * has not been set on this message
   */
  VendorSpecificApplicationIdAvp getVendorSpecificApplicationId();

  /**
   * Sets the value of the Vendor-Specific-Application-Id AVP, of type
   * Grouped.
   *
   * @throws IllegalStateException if setVendorSpecificApplicationId has already been called
   */
  void setVendorSpecificApplicationId(VendorSpecificApplicationIdAvp vendorSpecificApplicationId);

  /**
   * Returns true if the Auth-Session-State AVP is present in the message.
   */
  boolean hasAuthSessionState();

  /**
   * Returns the value of the Auth-Session-State AVP, of type Enumerated. A
   * return value of null implies that the AVP has not been set.
   */
  AuthSessionStateType getAuthSessionState();

  /**
   * Sets the value of the Auth-Session-State AVP, of type Enumerated.
   *
   * @throws IllegalStateException if setAuthSessionState has already been called
   */
  void setAuthSessionState(AuthSessionStateType authSessionState);

  /**
   * Returns true if the Originating-Request AVP is present in the message.
   */
  boolean hasOriginatingRequest();

  /**
   * Returns the value of the Originating-Request AVP, of type Enumerated. A
   * return value of null implies that the AVP has not been set.
   */
  OriginatingRequest getOriginatingRequest();

  /**
   * Sets the value of the Originating-Request AVP, of type Enumerated.
   *
   * @throws IllegalStateException if setOriginatingRequest has already been called
   */
  void setOriginatingRequest(OriginatingRequest originatingRequest);

  /**
   * Returns the set of Supported-Features AVPs. The returned array contains
   * the AVPs in the order they appear in the message. A return value of null
   * implies that no Supported-Features AVPs have been set. The elements in
   * the given array are SupportedFeatures objects.
   */
  SupportedFeaturesAvp[] getSupportedFeatureses();

  /**
   * Sets a single Supported-Features AVP in the message, of type Grouped.
   *
   * @throws IllegalStateException if setSupportedFeatures or setSupportedFeatureses has already
   *                               been called
   */
  void setSupportedFeatures(SupportedFeaturesAvp supportedFeatures);

  /**
   * Sets the set of Supported-Features AVPs, with all the values in the given
   * array. The AVPs will be added to message in the order in which they
   * appear in the array.
   * <p/>
   * Note: the array must not be altered by the caller following this call,
   * and getSupportedFeatureses() is not guaranteed to return the same array
   * instance, e.g. an "==" check would fail.
   *
   * @throws IllegalStateException if setSupportedFeatures or setSupportedFeatureses has already
   *                               been called
   */
  void setSupportedFeatureses(SupportedFeaturesAvp[] supportedFeatureses);

  /**
   * Returns true if the Public-Identity AVP is present in the message.
   */
  boolean hasPublicIdentity();

  /**
   * Returns the value of the Public-Identity AVP, of type UTF8String.
   * A return value of null implies that the AVP has not been set.
   */
  String getPublicIdentity();

  /**
   * Sets the value of the Public-Identity AVP, of type UTF8String.
   *
   * @throws IllegalStateException if setPublicIdentity has already been called
   */
  void setPublicIdentity(String publicIdentity);

  /**
   * Returns true if the User-Authorization-Type AVP is present in the message.
   */
  boolean hasUserAuthorizationType();

  /**
   * Returns the value of the User-Authorization-Type AVP, of type Enumerated. A
   * return value of null implies that the AVP has not been set.
   */
  UserAuthorizationType getUserAuthorizationType();

  /**
   * Sets the value of the User-Authorization-Type AVP, of type Enumerated.
   *
   * @throws IllegalStateException if setAuthSessionState has already been called
   */
  void setUserAuthorizationType(UserAuthorizationType userAuthorizationType);

  /**
   * Returns the set of Proxy-Info AVPs. The returned array contains
   * the AVPs in the order they appear in the message.
   * A return value of null implies that no Proxy-Info AVPs have been set.
   * The elements in the given array are ProxyInfo objects.
   */
  ProxyInfoAvp[] getProxyInfos();

  /**
   * Sets a single Proxy-Info AVP in the message, of type Grouped.
   *
   * @throws IllegalStateException if setProxyInfo or setProxyInfos
   *                               has already been called
   */
  void setProxyInfo(ProxyInfoAvp proxyInfo);

  /**
   * Sets the set of Proxy-Info AVPs, with all the values in the given array.
   * The AVPs will be added to message in the order in which they appear in the array.
   * <p/>
   * Note: the array must not be altered by the caller following this call, and
   * getProxyInfos() is not guaranteed to return the same array instance,
   * e.g. an "==" check would fail.
   *
   * @throws IllegalStateException if setProxyInfo or setProxyInfos
   *                               has already been called
   */
  void setProxyInfos(ProxyInfoAvp[] proxyInfos);

  /**
   * Returns the set of Route-Record AVPs. The returned array contains
   * the AVPs in the order they appear in the message.
   * A return value of null implies that no Route-Record AVPs have been set.
   * The elements in the given array are DiameterIdentity objects.
   */
  DiameterIdentity[] getRouteRecords();

  /**
   * Sets a single Route-Record AVP in the message, of type DiameterIdentity.
   *
   * @throws IllegalStateException if setRouteRecord or setRouteRecords
   *                               has already been called
   */
  void setRouteRecord(DiameterIdentity routeRecord);

  /**
   * Sets the set of Route-Record AVPs, with all the values in the given array.
   * The AVPs will be added to message in the order in which they appear in the array.
   * <p/>
   * Note: the array must not be altered by the caller following this call, and
   * getRouteRecords() is not guaranteed to return the same array instance,
   * e.g. an "==" check would fail.
   *
   * @throws IllegalStateException if setRouteRecord or setRouteRecords
   *                               has already been called
   */
  void setRouteRecords(DiameterIdentity[] routeRecords);


  /**
   * Returns true if the Public-Identity AVP is present in the message.
   */
  boolean hasSessionPriority();

  /**
   * Returns the value of the Public-Identity AVP, of type UTF8String.
   * A return value of null implies that the AVP has not been set.
   */
  SessionPriority getSessionPriority();

  /**
   * Sets the value of the Public-Identity AVP, of type UTF8String.
   *
   * @throws IllegalStateException if setPublicIdentity has already been called
   */
  void setSessionPriority(SessionPriority sessionPriority);
}