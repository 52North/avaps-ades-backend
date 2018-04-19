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
package org.n52.project.eoep.io.datahandler.parser;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;

import org.n52.javaps.annotation.Properties;
import org.n52.javaps.description.TypedProcessInputDescription;
import org.n52.javaps.io.AbstractPropertiesInputOutputHandler;
import org.n52.javaps.io.Data;
import org.n52.javaps.io.DecodingException;
import org.n52.javaps.io.InputHandler;
import org.n52.project.eoep.io.data.binding.complex.ApplicationPackageBinding;
import org.n52.shetland.ogc.wps.Format;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * This class parses String representations out of JTS Geometries.
 *
 * @author Benjamin Pross
 *
 */
@Properties(
        defaultPropertyFileName = "applicationpackage.properties")
public class ApplicationPackageParser extends AbstractPropertiesInputOutputHandler implements InputHandler {

    private static Logger LOGGER = LoggerFactory.getLogger(ApplicationPackageParser.class);

    public ApplicationPackageParser() {
        super();
        addSupportedBinding(ApplicationPackageBinding.class);
    }

    public Data<?> parse(TypedProcessInputDescription<?> description,
            InputStream input,
            Format format) throws IOException, DecodingException {

        File targetFile = File.createTempFile("applicationpackage", ".xml");

        LOGGER.debug("Created tmp file for ApplicationPackage: " + targetFile.getAbsolutePath());

        Files.copy(input, targetFile.toPath(), StandardCopyOption.REPLACE_EXISTING);
        try {
            input.close();
        } catch (IOException e) {
            LOGGER.error("IOException occurred while trying too close InputStream.", e);
        }

        return new ApplicationPackageBinding(targetFile);
    }

}
