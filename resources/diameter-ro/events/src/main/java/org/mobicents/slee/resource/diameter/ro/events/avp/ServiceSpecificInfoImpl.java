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

package org.mobicents.slee.resource.diameter.ro.events.avp;

import net.java.slee.resource.diameter.ro.events.avp.ServiceSpecificInfo;
import org.mobicents.slee.resource.diameter.base.events.avp.GroupedAvpImpl;


/**
 * Implementation of the Service-Specific-Info grouped AVP type.<br>
 * <br>
 *
 * @author <a href="mailto:grzegorz.figiel@pro-ids.com"> Grzegorz Figiel [ProIDS] </a>
 */
public class ServiceSpecificInfoImpl extends GroupedAvpImpl implements ServiceSpecificInfo {

  public ServiceSpecificInfoImpl() {
    super();
  }

  /**
   * @param code
   * @param vendorId
   * @param mnd
   * @param prt
   * @param value
   */
  public ServiceSpecificInfoImpl(int code, long vendorId, int mnd, int prt, byte[] value ) {
    super( code, vendorId, mnd, prt, value );
  }

  /**
   * Returns the value of the Service-Specific-Data AVP, of type UTF8String. A return value of null implies that the AVP has not been set.
   */
  public String getServiceSpecificData() {
    return getAvpAsUTF8String(DiameterRoAvpCodes.SERVICE_SPECIFIC_DATA, DiameterRoAvpCodes.TGPP_VENDOR_ID);
  }

  /**
   * Returns the value of the Service-Specific-Type AVP, of type Unsigned32. A return value of null implies that the AVP has not been set.
   */
  public long getServiceSpecificType() {
      return getAvpAsUnsigned32(DiameterRoAvpCodes.SERVICE_SPECIFIC_TYPE, DiameterRoAvpCodes.TGPP_VENDOR_ID);
  }

  /**
   * Returns true if the Service-Specific-Data AVP is present in the message.
   */
  public boolean hasServiceSpecificData() {
    return hasAvp( DiameterRoAvpCodes.SERVICE_SPECIFIC_DATA, DiameterRoAvpCodes.TGPP_VENDOR_ID );
  }

  /**
   * Returns true if the Service-Specific-Type AVP is present in the message.
   */
  public boolean hasServiceSpecificType() {
    return hasAvp( DiameterRoAvpCodes.SERVICE_SPECIFIC_TYPE, DiameterRoAvpCodes.TGPP_VENDOR_ID );
  }

  /**
   * Sets the value of the Service-Specific-Data AVP, of type UTF8String.
   *
   * @param serviceSpecificData
   */
  public void setServiceSpecificData(String serviceSpecificData) {
    addAvp(DiameterRoAvpCodes.SERVICE_SPECIFIC_DATA, serviceSpecificData);

  }

  /**
   * Sets the value of the Service-Specific-Type AVP, of type Unsigned32.
   *
   * @param serviceSpecificType
   */
  public void setServiceSpecificType(long serviceSpecificType) {
      addAvp(DiameterRoAvpCodes.SERVICE_SPECIFIC_TYPE, serviceSpecificType);
  }
}
