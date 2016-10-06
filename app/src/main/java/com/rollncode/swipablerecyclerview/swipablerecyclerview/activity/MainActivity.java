package com.rollncode.swipablerecyclerview.swipablerecyclerview.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;

import com.rollncode.swipablerecyclerview.swipablerecyclerview.R;
import com.rollncode.swipablerecyclerview.swipablerecyclerview.adapter.DataAdapter;
import com.rollncode.swipablerecyclerview.swipablerecyclerview.utility.carousellayoutmanager.CarouselLayoutManager;
import com.rollncode.swipablerecyclerview.swipablerecyclerview.utility.carousellayoutmanager.CarouselZoomPostLayoutListener;
import com.rollncode.swipablerecyclerview.swipablerecyclerview.utility.carousellayoutmanager.CenterScrollListener;

public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final RecyclerView recyclerView = (RecyclerView) findViewById(R.id.recyclerView);
        final DataAdapter adapter = new DataAdapter();
//        final RecyclerLayoutManager manager = new RecyclerLayoutManager();
//        final CarouselLayoutManager layoutManager = new CarouselLayoutManager(CarouselLayoutManager.VERTICAL);
//        recyclerView.setLayoutManager(layoutManager);
//        recyclerView.setHasFixedSize(true);
//
////        recyclerView.setLayoutManager(manager);
//        recyclerView.setAdapter(adapter);
//
////        recyclerView.setChildDrawingOrderCallback(new RecyclerView.ChildDrawingOrderCallback() {
////            @Override
////            public int onGetChildDrawingOrder(int childCount, int i) {
////                return childCount - i - 1;
////            }
////        });
//
//        // vertical and cycle layout
//        layoutManager.setPostLayoutListener(new CarouselZoomPostLayoutListener());
//        recyclerView.addOnScrollListener(new CenterScrollListener());

        initRecyclerView(recyclerView, new CarouselLayoutManager(CarouselLayoutManager.VERTICAL, false), adapter);



        // Extend the Callback class
//        ItemTouchHelper.Callback ithCallback = new ItemTouchHelper.Callback() {
//            //and in your imlpementaion of
//            public boolean onMove(RecyclerView recyclerView, RecyclerView.ViewHolder viewHolder, RecyclerView.ViewHolder target) {
//                // get the viewHolder's and target's positions in your adapter data, swap them
//                Collections.swap(adapter.getData(), viewHolder.getAdapterPosition(), target.getAdapterPosition());
//                // and notify the adapter that its dataset has changed
//                adapter.notifyItemMoved(viewHolder.getAdapterPosition(), target.getAdapterPosition());
//                return true;
//            }
//
//            @Override
//            public void onSwiped(RecyclerView.ViewHolder viewHolder, int direction) {
//                viewHolder.getItemId();
//            }
//
//            //defines the enabled move directions in each state (idle, swiping, dragging).
//            @Override
//            public int getMovementFlags(RecyclerView recyclerView, RecyclerView.ViewHolder viewHolder) {
//                return makeFlag(ItemTouchHelper.ACTION_STATE_DRAG, ItemTouchHelper.DOWN | ItemTouchHelper.UP | ItemTouchHelper.START | ItemTouchHelper.END);
//            }
//
//            @Override
//            public void onMoved(RecyclerView recyclerView, RecyclerView.ViewHolder viewHolder, int fromPos, RecyclerView.ViewHolder target, int toPos, int x, int y) {
//                super.onMoved(recyclerView, viewHolder, fromPos, target, toPos, x, y);
//            }
//
//            @Override
//            public void clearView(RecyclerView recyclerView, RecyclerView.ViewHolder viewHolder) {
//                super.clearView(recyclerView, viewHolder);
//
////                ((DataAdapter.ViewHolder) viewHolder).getView().setAlpha();
//                ((DataAdapter.ViewHolder) viewHolder).getView().animate()
//                        .setDuration(250)
//                        .alpha(0F)
//                        .start();
//                adapter.remove(viewHolder.getAdapterPosition());
//            }
//
//            @Override
//            public void onSelectedChanged(RecyclerView.ViewHolder viewHolder, int actionState) {
//                super.onSelectedChanged(viewHolder, actionState);
//            }
//
//            @Override
//            public boolean canDropOver(RecyclerView recyclerView, RecyclerView.ViewHolder current, RecyclerView.ViewHolder target) {
//                return false;//super.canDropOver(recyclerView, current, target);
//            }
//
//            @Override
//            public RecyclerView.ViewHolder chooseDropTarget(RecyclerView.ViewHolder selected, List<RecyclerView.ViewHolder> dropTargets, int curX, int curY) {
//                return super.chooseDropTarget(selected, dropTargets, curX, curY);
//            }
//        };
//
//        ItemTouchHelper ith = new ItemTouchHelper(ithCallback);
//        ith.attachToRecyclerView(recyclerView);
//
//
//
//        recyclerView.setOnDragListener(new View.OnDragListener() {
//            @Override
//            public boolean onDrag(View view, DragEvent dragEvent) {
//                return false;
//            }
//
//
//        });
    }

    private void initRecyclerView(final RecyclerView recyclerView, final CarouselLayoutManager layoutManager, final DataAdapter adapter) {
        // enable zoom effect. this line can be customized
        layoutManager.setPostLayoutListener(new CarouselZoomPostLayoutListener());

        recyclerView.setLayoutManager(layoutManager);
        // we expect only fixed sized item for now
        recyclerView.setHasFixedSize(true);
        // sample adapter with random data
        recyclerView.setAdapter(adapter);
        // enable center post scrolling
        recyclerView.addOnScrollListener(new CenterScrollListener());
        // enable center post touching on item and item click listener
//        DefaultChildSelectionListener.initCenterItemListener(new DefaultChildSelectionListener.OnCenterItemClickListener() {
//            @Override
//            public void onCenterItemClicked(@NonNull RecyclerView recyclerView, @NonNull CarouselLayoutManager carouselLayoutManager, @NonNull View v) {
//                final int position = recyclerView.getChildLayoutPosition(v);
//                final String msg = String.format(Locale.US, "Item %1$d was clicked", position);
//                Toast.makeText(MainActivity.this, msg, Toast.LENGTH_SHORT).show();
//            }
//        }, recyclerView, layoutManager);

        layoutManager.addOnItemSelectionListener(new CarouselLayoutManager.OnCenterItemSelectionListener() {

            @Override
            public void onCenterItemChanged(final int adapterPosition) {
                if (CarouselLayoutManager.INVALID_POSITION != adapterPosition) {
//                    final int value = adapter.mPosition[adapterPosition];
/*
                    adapter.mPosition[adapterPosition] = (value % 10) + (value / 10 + 1) * 10;
                    adapter.notifyItemChanged(adapterPosition);
*/
                }
            }
        });
    }
}
