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

import org.n52.javaps.algorithm.annotation.Algorithm;
import org.n52.javaps.algorithm.annotation.ComplexOutput;
import org.n52.javaps.algorithm.annotation.Execute;
import org.n52.javaps.algorithm.annotation.LiteralInput;
import org.n52.project.eoep.io.data.binding.complex.UndeployResultXMLBinding;

import net.opengis.wps.x20.UndeployResultDocument;
import net.opengis.wps.x20.UndeployResultType;

@Algorithm(
        identifier = "UndeployProcess",
        title = "Undeploy Process",
        abstrakt = "This method removes a previously deployed process from the WPS.",
        version = "1.0.0")
public class UndeployProcess {

    private UndeployResultDocument undeployResultDocument;

    @LiteralInput(
            identifier = "processIdentifier",
            title = "Process Identifier",
            abstrakt = "The identifier of the process to remove from the WPS.")
   public String processIdentifier;

    @ComplexOutput(
            identifier = "undeployResult",
            title = "Undeploy Result",
            abstrakt = "This is the server's response when undeploying a process. A successful response will contain the identifier of the undeployed process.",
            binding = UndeployResultXMLBinding.class)
    public UndeployResultDocument getDeployResult() {
        return undeployResultDocument;
    }

    @Execute
    public void run() {

        undeployResultDocument = UndeployResultDocument.Factory.newInstance();

        UndeployResultType undeployResult = undeployResultDocument.addNewUndeployResult();

        undeployResult.setFailureReason("Not yet implemented");

    }

}
