/**
 * The contents of this file are subject to the OpenMRS Public License
 * Version 1.0 (the "License"); you may not use this file except in
 * compliance with the License. You may obtain a copy of the License at
 * http://license.openmrs.org
 *
 * Software distributed under the License is distributed on an "AS IS"
 * basis, WITHOUT WARRANTY OF ANY KIND, either express or implied. See the
 * License for the specific language governing rights and limitations
 * under the License.
 *
 * Copyright (C) OpenMRS, LLC.  All Rights Reserved.
 */

package org.openmrs.module.keaddonexample.metadata;

import org.openmrs.module.metadatadeploy.bundle.AbstractMetadataBundle;
import org.springframework.stereotype.Component;

import static org.openmrs.module.metadatadeploy.bundle.CoreConstructors.*;

/**
 * Example metadata bundle
 */
@Component
public class ExampleMetadata extends AbstractMetadataBundle {

	public static class _EncounterType {
		public static final String EXAMPLE = "d69dedbd-3933-4e44-8292-bea939ce980a";
	}

	public static class _Form {
		public static final String EXAMPLE = "b694b1bc-2086-47dd-a4ad-ba48f9471e4b";
        public static final String EIDLABREQUISITION = "e82608d8-6d03-486c-a4c4-c40e8d54e652";
	}

    public static class _program {
        public static final String MCHEXAMPLE = "b32ca1cc-5dad-48e4-b340-6d7857364f5b";
        public static final String POSTNATALCARE = "199f012f-1a94-402c-b12d-b869edb7994e";
    }
	/**
	 * @see org.openmrs.module.metadatadeploy.bundle.AbstractMetadataBundle#install()
	 */
	@Override
	public void install() {
		install(encounterType("Example encounter", "Just an example", _EncounterType.EXAMPLE));

		install(form("Example form", null, _EncounterType.EXAMPLE,"1", _Form.EXAMPLE));
        install (form ("EID Lab Requisition Form", null,_EncounterType.EXAMPLE,"1",_Form.EIDLABREQUISITION));


        install (program("MCH Trial program", "Just a trial program", Dictionary.EXAMPLE ,_program.MCHEXAMPLE ));

        install (program("Post Natal Care", "Post Natal Care program", Dictionary.EXAMPLE, _program.POSTNATALCARE));
	}
}