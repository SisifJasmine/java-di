package org.osgl.inject.annotation;

/*-
 * #%L
 * OSGL Genie
 * %%
 * Copyright (C) 2017 OSGL (Open Source General Library)
 * %%
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * 
 *      http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 * #L%
 */

import org.osgl.inject.BeanTransformer;

import java.lang.annotation.*;

/**
 * Used to tag an annotation with {@link org.osgl.Osgl.Function}
 * specification.
 */
@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.ANNOTATION_TYPE, ElementType.FIELD, ElementType.PARAMETER})
public @interface Transform {
    /**
     * Specify the {@link BeanTransformer bean transformer} implementation
     */
    Class<? extends BeanTransformer> value();
}
