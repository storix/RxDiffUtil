/*
 * MIT License
 *
 * Copyright (c) 2017 Stan Mots (Storix)
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all
 * copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
 * SOFTWARE.
 */

package com.stolets.rxdiffutil;

import android.app.Activity;
import android.support.annotation.NonNull;

import com.stolets.rxdiffutil.diffrequest.DiffRequestManagerHolder;
import com.stolets.rxdiffutil.diffrequest.DiffRequestManagerHolderRetriever;

import static com.stolets.rxdiffutil.internal.Preconditions.checkNotNull;

/**
 * Represents an entry point for making diff requests.
 */
@SuppressWarnings("WeakerAccess")
public final class RxDiffUtil {
    private RxDiffUtil() {
    }

    /**
     * Creates the retained fragment that is used to listen to the given activity lifecycle events.
     *
     * @param activity The {@link Activity} the diff requests lifecycle will be bound to.
     * @return The {@link DiffRequestManagerHolder} retrieved from the retained fragment.
     * @throws NullPointerException If the given activity is null.
     */
    @NonNull
    public static DiffRequestManagerHolder bindTo(@NonNull final Activity activity) {
        checkNotNull(activity, "activity must not be null!");
        return DiffRequestManagerHolderRetriever.retrieveFrom(activity);
    }
}
