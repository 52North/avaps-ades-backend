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
package org.n52.project.eoep.algorithm;

import java.io.File;

import org.n52.javaps.algorithm.annotation.Algorithm;
import org.n52.javaps.algorithm.annotation.ComplexInput;
import org.n52.javaps.algorithm.annotation.ComplexOutput;
import org.n52.javaps.algorithm.annotation.Execute;
import org.n52.project.eoep.io.data.binding.complex.ApplicationPackageBinding;
import org.n52.project.eoep.io.data.binding.complex.DeployResultXMLBinding;

import net.opengis.wps.x20.DeployResultDocument;
import net.opengis.wps.x20.DeployResultType;

@Algorithm(
        identifier = "DeployProcess",
        title = "Deploy Process",
        abstrakt = "This method will deploy an application encapsulated within a Docker container as a process accessible through the WPS interface.",
        version = "1.0.0")
public class DeployProcess {

    private File applicationPackage;

    private DeployResultDocument deployResultDocument;

    @ComplexInput(
            identifier = "applicationPackage",
            title = "Application Package",
            abstrakt = "An application package, encoded as an ATOM-encoded OWS context document, describing the details of the application.",
            binding = ApplicationPackageBinding.class)
    public void setApplicationPackage(File f) {
        this.applicationPackage = f;
    }

    @ComplexOutput(
            identifier = "deployResult",
            title = "Deploy Result",
            abstrakt = "The server's response to deploying a process.  A successful response will contain a summary of the deployed process.",
            binding = DeployResultXMLBinding.class)
    public DeployResultDocument getDeployResult() {
        return deployResultDocument;
    }

    @Execute
    public void run() {

        deployResultDocument = DeployResultDocument.Factory.newInstance();

        DeployResultType deployResult = deployResultDocument.addNewDeployResult();

        deployResult.setFailureReason("Not yet implemented");

    }

}
