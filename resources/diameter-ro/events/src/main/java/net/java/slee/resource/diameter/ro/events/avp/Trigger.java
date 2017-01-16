/*
 * TeleStax, Open Source Cloud Communications
 * Copyright 2011-2016, Telestax Inc and individual contributors
 * by the @authors tag.
 *
 * This program is free software: you can redistribute it and/or modify
 * under the terms of the GNU Affero General Public License as
 * published by the Free Software Foundation; either version 3 of
 * the License, or (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU Affero General Public License for more details.
 *
 * You should have received a copy of the GNU Affero General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>
 *
 */
package net.java.slee.resource.diameter.ro.events.avp;

import net.java.slee.resource.diameter.base.events.avp.GroupedAvp;

/**
 * Defines an interface representing the Trigger grouped AVP type.<br>
 * <br>
 * From the Diameter Ro Reference Point Protocol Details (3GPP TS 32.299 V8.25.0) specification:
 * <pre>
 * The Trigger AVP (AVP code 1264) is of type Grouped and holds the trigger types. The presence of the Trigger AVP without any Trigger-Type AVP in a CCA allows OCS to disable all the triggers. The presence of the Trigger AVP in the CCR identifies the event(s) triggering the CCR.
 *
 * It has the following ABNF grammar:
 *  <Trigger>::		=		< AVP Header: 1264 >
 *      * [ Trigger-Type ]
 *
 * </pre>
 *
 * @author <a href="mailto:grzegorz.figiel@pro-ids.com"> Grzegorz Figiel [ProIDS] </a>
 */
public interface Trigger extends GroupedAvp {

    /**
     * Returns the set of Trigger-Type AVPs of type Enumerated. The returned array contains the AVPs in the order they appear in the message. A return value of null implies that no AVPs have been set.
     */
    abstract TriggerType[] getTriggerTypes();

    /**
     * Sets the value of the Trigger-Type AVP, of type Enumerated.
     */
    abstract void setTriggerType(TriggerType triggerType);

    /**
     * Sets the set of Trigger-Type AVPs, with all the values in the given array. The AVPs will be added to message in the order in which they appear in the array.
     * Note: the array must not be altered by the caller following this call, and getTriggerTypes() is not guaranteed to return the same array instance, e.g. an "==" check would fail.
     */
    abstract void setTriggerTypes(TriggerType[] triggerTypes);

}
