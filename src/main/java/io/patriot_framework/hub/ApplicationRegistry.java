/*
 * Copyright 2019 Patriot project
 *
 *    Licensed under the Apache License, Version 2.0 (the "License");
 *    you may not use this file except in compliance with the License.
 *    You may obtain a copy of the License at
 *
 *        http://www.apache.org/licenses/LICENSE-2.0
 *
 *    Unless required by applicable law or agreed to in writing, software
 *    distributed under the License is distributed on an "AS IS" BASIS,
 *    WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *    See the License for the specific language governing permissions and
 *    limitations under the License.
 */

package io.patriot_framework.hub;

import io.patriot_framework.network.simulator.api.model.devices.application.Application;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public class ApplicationRegistry {
    private Map<String, Application> deployedApplications = new HashMap<>();

    public boolean putDevice(Application a) {
        if (deployedApplications.containsKey(a.getName())) {
            return false;
        }

        deployedApplications.put(a.getName(), a);

        return true;
    }

    public Application getDevice(String name) {
        return deployedApplications.get(name);
    }

    public void putDevices(Collection<Application> apps) {
        apps.forEach(app -> this.putDevice(app));
    }

}