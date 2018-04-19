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
package org.n52.project.eoep.io.data.binding.complex;

import org.n52.javaps.io.complex.ComplexData;

import net.opengis.wps.x20.UndeployResultDocument;

public class UndeployResultXMLBinding implements ComplexData<UndeployResultDocument> {

    /**
     *
     */
    private static final long serialVersionUID = -5342143348283211335L;

    private UndeployResultDocument undeployResult;

    public UndeployResultXMLBinding(UndeployResultDocument undeployResult) {
        this.undeployResult = undeployResult;
    }

    @Override
    public UndeployResultDocument getPayload() {
        return undeployResult;
    }

    @Override
    public Class<UndeployResultDocument> getSupportedClass() {
        return UndeployResultDocument.class;
    }

}
