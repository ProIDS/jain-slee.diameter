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

import net.java.slee.resource.diameter.base.events.avp.Enumerated;

import java.io.StreamCorruptedException;

/**
 * Java class to represent the InterfaceType enumerated type.
 *
 * @author <a href="mailto:grzegorz.figiel@pro-ids.com"> Grzegorz Figiel [ProIDS] </a>
 */
public class InterfaceType implements Enumerated, java.io.Serializable {

    private static final long serialVersionUID = 1L;

    public static final int _UNKNOWN = 0;
    public static final int _MOBILE_ORIGINATING = 1;
    public static final int _MOBILE_TERMINATING = 2;
    public static final int _APPLICATION_ORIGINATING = 3;
    public static final int _APPLICATION_TERMINATION = 4;

    public static final InterfaceType UNKNOWN = new InterfaceType(_UNKNOWN);
    public static final InterfaceType MOBILE_ORIGINATING = new InterfaceType(_MOBILE_ORIGINATING);
    public static final InterfaceType MOBILE_TERMINATING = new InterfaceType(_MOBILE_TERMINATING);
    public static final InterfaceType APPLICATION_ORIGINATING = new InterfaceType(_APPLICATION_ORIGINATING);
    public static final InterfaceType APPLICATION_TERMINATION = new InterfaceType(_APPLICATION_TERMINATION);

    private InterfaceType(int v) {
        value = v;
    }

    /**
     * Return the value of this instance of this enumerated type.
     */
    public static InterfaceType fromInt(int type) {
        switch (type) {
            case _UNKNOWN:
                return UNKNOWN;
            case _MOBILE_ORIGINATING:
                return MOBILE_ORIGINATING;
            case _MOBILE_TERMINATING:
                return MOBILE_TERMINATING;
            case _APPLICATION_ORIGINATING:
                return APPLICATION_ORIGINATING;
            case _APPLICATION_TERMINATION:
                return APPLICATION_TERMINATION;

            default:
                throw new IllegalArgumentException("Invalid InterfaceType value: " + type);
        }
    }

    public int getValue() {
        return value;
    }

    public String toString() {
        switch (value) {
            case _UNKNOWN:
                return "UNKNOWN";
            case _MOBILE_ORIGINATING:
                return "MOBILE_ORIGINATING";
            case _MOBILE_TERMINATING:
                return "MOBILE_TERMINATING";
            case _APPLICATION_ORIGINATING:
                return "APPLICATION_ORIGINATING";
            case _APPLICATION_TERMINATION:
                return "APPLICATION_TERMINATION";

            default:
                return "<Invalid Value>";
        }
    }

    private Object readResolve() throws StreamCorruptedException {
        try {
            return fromInt(value);
        } catch (IllegalArgumentException iae) {
            throw new StreamCorruptedException("Invalid internal state found: " + value);
        }
    }

    private int value = 0;

}
