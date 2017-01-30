/*****************************************************************
 *   Licensed to the Apache Software Foundation (ASF) under one
 *  or more contributor license agreements.  See the NOTICE file
 *  distributed with this work for additional information
 *  regarding copyright ownership.  The ASF licenses this file
 *  to you under the Apache License, Version 2.0 (the
 *  "License"); you may not use this file except in compliance
 *  with the License.  You may obtain a copy of the License at
 *
 *    http://www.apache.org/licenses/LICENSE-2.0
 *
 *  Unless required by applicable law or agreed to in writing,
 *  software distributed under the License is distributed on an
 *  "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 *  KIND, either express or implied.  See the License for the
 *  specific language governing permissions and limitations
 *  under the License.
 ****************************************************************/
package org.apache.cayenne.dbimport;

import org.apache.cayenne.CayenneRuntimeException;
import org.apache.cayenne.resource.Resource;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import java.io.IOException;
import java.io.Writer;

/**
 * @since 4.0
 * @deprecated
 */
public class DefaultReverseEngineeringWriter implements ReverseEngineeringWriter {
    private final static Log LOGGER = LogFactory.getLog(DefaultReverseEngineeringWriter.class);

    @Override
    public Resource write(ReverseEngineering reverseEngineering, Writer writer) throws CayenneRuntimeException {

        try {
            JAXBContext context = JAXBContext.newInstance(reverseEngineering.getClass());
            Marshaller marshaller = context.createMarshaller();
            marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
            marshaller.setProperty(Marshaller.JAXB_ENCODING, "UTF-8");
            marshaller.setProperty(Marshaller.JAXB_SCHEMA_LOCATION,
                    "http://cayenne.apache.org/schema/8/reverseEngineering http://cayenne.apache.org/schema/8/reverseEngineering.xsd");

            marshaller.setProperty(Marshaller.JAXB_FRAGMENT, true);
            marshaller.marshal(reverseEngineering, writer);
            writer.close();
            return null;//reverseEngineering.getConfigurationSource();
        } catch (JAXBException | IOException e) {
            LOGGER.error(e.getMessage(), e);
            throw new CayenneRuntimeException(e);
        }
    }
}
