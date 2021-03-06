/*
 * Copyright 2018 52°North Initiative for Geospatial Open Source
 * Software GmbH
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *    http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.n52.project.eoep.io.datahandler.generator;

import java.io.IOException;
import java.io.InputStream;

import org.n52.javaps.annotation.Properties;
import org.n52.javaps.description.TypedProcessOutputDescription;
import org.n52.javaps.io.AbstractPropertiesInputOutputHandler;
import org.n52.javaps.io.Data;
import org.n52.javaps.io.EncodingException;
import org.n52.javaps.io.OutputHandler;
import org.n52.project.eoep.io.data.binding.complex.DeployResultXMLBinding;
import org.n52.shetland.ogc.wps.Format;

import net.opengis.wps.x20.DeployResultDocument;

/**
 * This class generates a XML representation out of a (Un-)DeployResult
 * document.
 *
 * @author Benjamin Pross
 *
 */
@Properties(
        defaultPropertyFileName = "deployresultxml.properties")
public class DeployResultXMLGenerator extends AbstractPropertiesInputOutputHandler implements OutputHandler {

    public DeployResultXMLGenerator() {
        super();
        addSupportedBinding(DeployResultXMLBinding.class);
    }

    public InputStream generate(TypedProcessOutputDescription<?> description,
            Data<?> data,
            Format format) throws IOException, EncodingException {

        if (data instanceof DeployResultXMLBinding) {
            DeployResultDocument deployResultDocument = ((DeployResultXMLBinding) data).getPayload();
            return deployResultDocument.newInputStream();
        }
        return null;
    }

}
