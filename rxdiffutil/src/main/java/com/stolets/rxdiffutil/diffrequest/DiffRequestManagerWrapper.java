package com.stolets.rxdiffutil.diffrequest;

import android.support.annotation.NonNull;

import com.stolets.rxdiffutil.RxDiffResult;

import io.reactivex.Single;

import static com.stolets.rxdiffutil.internal.Preconditions.checkArgument;
import static com.stolets.rxdiffutil.internal.Preconditions.checkNotNull;


/**
 * This class is used as a wrapper around {@link DiffRequestManager} to handle a request with the appropriate tag.
 */
@SuppressWarnings("WeakerAccess")
public final class DiffRequestManagerWrapper {
    @NonNull
    private final DiffRequestManager mDiffRequestManager;
    @NonNull
    private final String mTag;

    /**
     * Constructs a wrapper around {@link DiffRequestManager}.
     *
     * @param diffRequestManager {@link DiffRequestManager}.
     * @param tag                A tag that is passed to the underlying {@link DiffRequestManager} to handle the appropriate request.
     */
    public DiffRequestManagerWrapper(@NonNull final DiffRequestManager diffRequestManager, @NonNull final String tag) {
        checkNotNull(diffRequestManager, "diffRequestManager must not be null!");
        checkNotNull(tag, "tag string must not be null!");
        checkArgument(!tag.isEmpty(), "tag string must not be empty!");

        this.mDiffRequestManager = diffRequestManager;
        this.mTag = tag;
    }

    /**
     * Starts the difference calculation in accordance with parameters specified in {@link DiffRequestBuilder}.
     *
     * @return {@link Single} you can subscribe to or null if the activity has been finished. It also returns null if you have passed {@link com.stolets.rxdiffutil.DefaultDiffCallback} to the builder, in this case the result is handled internally automatically.
     */
    @Nullable
    public Single<RxDiffResult> calculate() {
        final DiffRequestManager diffRequestManager = mDiffRequestManagerWeakRef.get();
        return diffRequestManager != null ? diffRequestManager.execute(mTag) : null;
    }

    /**
     * @return The tag you specified in {@link DiffRequestBuilder}.
     */
    @NonNull
    public String getTag() {
        return mTag;
    }
}
