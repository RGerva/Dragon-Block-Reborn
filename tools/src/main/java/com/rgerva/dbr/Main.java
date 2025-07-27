/**
 * Class: Main <T>
 * Created by: D56V1OK
 * On: 2025/jul.
 * <p>
 * GitHub: https://github.com/RGerva
 * <p>
 * Copyright (c) 2025 @RGerva. All Rights Reserved.
 * <p>
 * Licensed under the Apache License, Version 2.0 (the "License");
 * You may not use this file except in compliance with the License.
 * You may obtain a copy of the License at:
 * <p>
 * http://www.apache.org/licenses/LICENSE-2.0
 * <p>
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.rgerva.dbr;

import com.rgerva.dbr.gradle.GradleVersions;
import com.rgerva.dbr.jupiter.JUnitVersions;
import com.rgerva.dbr.moddev.ModDevVersions;
import com.rgerva.dbr.neoforge.NeoforgeVersions;
import com.rgerva.dbr.utils.LogUtils;

public class Main {
    public static final LogUtils.Logger LOGGER = LogUtils.getLogger();

    public static void main(String[] args) {

        NeoforgeVersions neo = new NeoforgeVersions();
        neo.neoforgeCheck();

        ModDevVersions modDevVersions = new ModDevVersions();
        modDevVersions.modDevCheck();

        JUnitVersions jUnitVersions = new JUnitVersions();
        jUnitVersions.junitCheck();

        GradleVersions gradle = new GradleVersions();
        gradle.gradleCheck();
    }
}