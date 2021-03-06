/*
 * Copyright 2016 DiffPlug
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.diffplug.spotless;

import java.io.File;
import java.util.Arrays;
import java.util.Collection;
import java.util.Set;

/**
 * Many spotless steps require third-party libraries, but we want to keep
 * Spotless' dependencies minimal.
 */
public interface Provisioner {
	/**
	 * Given a set of maven coordinates, returns a set of jars which
	 * include all of the specified coordinates and their dependencies.
	 */
	public Set<File> provisionWithDependencies(Collection<String> mavenCoordinates);

	/**
	 * Given a set of maven coordinates, returns a set of jars which
	 * include all of the specified coordinates and their dependencies.
	 */
	public default Set<File> provisionWithDependencies(String... mavenCoordinates) {
		return provisionWithDependencies(Arrays.asList(mavenCoordinates));
	}
}
